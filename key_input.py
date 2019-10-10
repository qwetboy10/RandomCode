#!/usr/bin/python
import struct
import time
import sys
import subprocess
import webbrowser

def handleKey(key):
    print("Key Code %s" % key)
    process = subprocess.Popen('active_window'.split(), stdout=subprocess.PIPE)
    output, error = process.communicate()
    konsole = (output.decode("utf-8").strip().replace('\x00','') == 'konsole')
    vscode = (output.decode("utf-8").strip().replace('\x00','') == 'konsole')
    vim = (output.decode("utf-8").strip().replace('\x00','') == 'konsole')
    if(key==69):
        webbrowser.get('/usr/bin/google-chrome-stable %s').open('http://google.com')
    if(key==71):
        webbrowser.get('/usr/bin/firefox %s').open('http://google.com')
    if(key==75):
        if(konsole):
            subprocess.Popen('xdotool key c o d e space period space ampersand ampersand space e x i t Return'.split())
        else:
            subprocess.Popen('code'.split())
    if(key==79):
        subprocess.Popen('xdotool key v i m Return'.split())
    if(key==82):
        subprocess.Popen('xdotool key super+Return'.split())
    if(key==98):
        subprocess.Popen('xdotool key g i t space a d d space period space ampersand ampersand space g i t space c o m m i t Return'.split())
    if(key==55):
        subprocess.Popen('xdotool key g i t space p u s h Return'.split())
    if(key==14):
        subprocess.Popen('xdotool key g i t space r e s e t space minus minus h a r d'.split())
    if(key==72):
        subprocess.Popen('mailspring'.split())
    if(key==73):
        subprocess.Popen('xdotool key n c p a m i x e r Return'.split())
    if(key==80):
        subprocess.Popen('xdotool key c l e a r Return'.split());
    if(key==81):
        subprocess.Popen('xdotool key Super+v'.split())
    if(key==83):
        subprocess.Popen('xdotool key Super+h'.split())
    if(key==96):
        subprocess.Popen('xdotool key F10'.split())

infile_path = "/dev/input/by-id/usb-ELECOM_ELECOM_Lunaris_USB_tenkeyboard-event-kbd"

#long int, long int, unsigned short, unsigned short, unsigned int
FORMAT = 'llHHI'
EVENT_SIZE = struct.calcsize(FORMAT)

#open file in binary mode
in_file = open(infile_path, "rb")

event = in_file.read(EVENT_SIZE)

while event:
    (tv_sec, tv_usec, t, code, value) = struct.unpack(FORMAT, event)

    if t != 0 or code != 0 or value != 0:
        print("Event t %u, code %u, value %u at %d.%d" % \
            (t, code, value, tv_sec, tv_usec))
        if(value==1):
            handleKey(code)
    else:
        # Events with code, type and value == 0 are "separator" events
        print("===========================================")

    event = in_file.read(EVENT_SIZE)

in_file.close()

    
