#! /usr/bin/bash

if [[ ! -e voj_launcher/Main.class ]]
then	
	javac voj_launcher/*.java
fi
java voj_launcher.Main $1
