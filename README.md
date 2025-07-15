# Overview
This app works by setting up a TCP socket server on the PC (server) and a socket client on the phone, 
which then (depends on version), prints them to the console (Mobile Version) or prints them to the java app (Desktop Version). 
This setup allows easy communications between phone and a PC. 


## How to use
- Install on your phone the app via Android Studio (open mobile version and run "App" to your phone via USB cable.
- Now you can decide which version to use:

### Mobile: 
1. Run Server.kt
2. Connect to shown ip (console) on your phone
3. Send message (message will appear in the console)

### Desktop:
1. Download .msi APP "InstallerPC.msi".
2. Click start server.
3. Check in cmd your local ip f.e "192.168.100.20"
4. Connect to the app from phone via IP.
5. Send message (message will appear in the app)
### OR
1. In terminal write ./gradlew run
2. The app will open, click "Start Server" button
3. Check in cmd your local ip f.e "192.168.100.20"
4. Connect to the app from phone via IP
5. Send message (message will appear in the app)

### Security Warning: This is an early version of the app and does not use encrypted communication. For now, do not use it on public Wi-Fi, as your messages could be intercepted.
### Keep in mind that this is early version of the app and it needs some UI improvements.


## License
This app is open-source. Feel free to modify or use it as you see fit, but please remember to credit the original authors.

![image](https://github.com/user-attachments/assets/c312828e-6ac3-41ad-a7bf-b6ef3887dc5d)![image](https://github.com/user-attachments/assets/319079b8-907e-46b9-8cb9-e825b0f73388)
