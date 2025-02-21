# Overview
This app works by setting up a TCP socket server on the PC (server) and a socket client on the phone, 
which then (depends on version), prints them to the console (Mobile Version) or prints them to the java app (Desktop Version). 
This setup allows easy communications between phone and a PC. 


## How to use
- Install on your phone the app via Android Studio (open mobile version and run "App" to your phone via USB cable.
- Now you can decide which version to use:

  # Mobile: 
1. Run Server.kt
2. Connect to shown ip (console) on your phone
3. Send message (message will appear in the console)

  # Desktop:
1. In terminal write ./gradlew run
2. The app will open, click "Start Server" button
3. Connect to the app from phone via IP
4. Send message (message will appear in the app)

### Keep in mind that this is early version of the app and it needs some UI improvements.
### Don't use the app on public Wi-Fi, it lacks encrypted communication 
