# Proteksi SecurityManager
-keep class com.t7apklym8.t7world.SecurityManager { *; }

# Proteksi LicenseCheckService
-keep class com.t7apklym8.t7world.LicenseCheckService { *; }

# Proteksi Firebase Cloud Messaging
-keep class com.t7apklym8.t7world.FirebaseMessageReceiver { *; }

# Proteksi SHA-1 Key di XML
-keepresourcexmlattributepattern security_key.xml