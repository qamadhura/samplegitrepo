from pydrive.auth import GoogleAuth
from pydrive.drive import GoogleDrive

gauth = GoogleAuth()
# Try to load saved client credentials
gauth.LoadCredentialsFile("mycreds.txt")
gauth.Refresh()

gauth.Authorize()

gauth.SaveCredentialsFile("mycreds.txt")

drive = GoogleDrive(gauth)

textfile = drive.CreateFile()
textfile.SetContentFile('getdemo.py')
textfile.Upload()
print textfile

drive.CreateFile({'id':textfile['id']}).GetContentFile('eng-dl.txt')
