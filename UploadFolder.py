from pydrive.auth import GoogleAuth
from pydrive.drive import GoogleDrive
from os import chdir, listdir, stat

gauth = GoogleAuth()
# Try to load saved client credentials
gauth.LoadCredentialsFile("mycreds.txt")

gauth.Refresh()

gauth.Authorize()

gauth.SaveCredentialsFile("mycreds.txt")

drive = GoogleDrive(gauth)



def create_folder(drive, folder_name,):

     folder_metadata = {
            'title': folder_name,
            'mimeType': 'application/vnd.google-apps.folder',


         }
     folder = drive.CreateFile(folder_metadata)
     folder.Upload()

         # Return folder informations
     print('title: %s, id: %s' % (folder['title'], folder['id']))
     return folder['id']

def upload_files(drive, folder_id, src_folder_name):

    try:
        chdir(src_folder_name)

    except OSError:
        print(src_folder_name + 'is missing')

    for file1 in listdir('.'):

        statinfo = stat(file1)
        if statinfo.st_size > 0:
            print('uploading ' + file1)
            # Upload file to folder.
            f = drive.CreateFile(
                {"parents": [{"kind": "drive#fileLink", "id": folder_id}]})
            f.SetContentFile(file1)
            f.Upload()

        else:
            print('file {0} is empty'.format(file1))

def main():
        src_folder_name = "D:\\asdf"
        dst_folder_name = "report"

        #check whether source folder exists and the continue

        folder_id =   create_folder(drive, dst_folder_name)
        print  (folder_id)
        upload_files(drive, folder_id, src_folder_name)



if __name__ == "__main__":
    main()
