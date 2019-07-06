#! /usr/bin/bash

if [[ ! -e avaj_launcher/Main.class ]]
then	
	javac avaj_launcher/*.java
fi
java avaj_launcher.Main $1
