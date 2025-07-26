
# 📶 Raspberry Pi Wi-Fi Setup with Yocto

This guide explains how to connect your Raspberry Pi (running a Yocto-built image) to a Wi-Fi network manually and enable automatic connection at boot.

---

## ⚙️ Manual & Boot-Time Wi-Fi Setup

1. **Create the config directory and Wi-Fi config file:**

```bash
mkdir -p /etc/wpa_supplicant
wpa_passphrase "realme P1 5G" "suryabalu01" > /etc/wpa_supplicant/wpa_supplicant-wlan0.conf
```

2. **Connect to Wi-Fi manually (optional for testing):**

```bash
wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant/wpa_supplicant-wlan0.conf
udhcpc -i wlan0
```

3. **Enable Wi-Fi at boot using rc.local:**

```bash
vi /etc/rc.local
```

Paste this content into the file:

```sh
#!/bin/sh -e
# Enable WiFi DHCP at boot
wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant/wpa_supplicant-wlan0.conf
udhcpc -i wlan0 &
exit 0
```

Make it executable and enable the rc-local service:

```bash
chmod +x /etc/rc.local
systemctl enable rc-local
systemctl start rc-local
```

---

## ✅ Final Checklist

- [x] Wi-Fi config present at `/etc/wpa_supplicant/wpa_supplicant-wlan0.conf`
- [x] `rc.local` contains startup Wi-Fi commands
- [x] `rc-local` service is enabled and running

> 📁 **Tip**: Keep this file (`wifi_setup.md`) in your repo for future reference or for others using your build.
