#!/bin/bash

fname="fdownloaded.csv"

clear
wget -q -O "$fname" http://samplecsvs.s3.amazonaws.com/Sacramentorealestatetransactions.csv
#We change the windows end of file format to linux
sed -i -e "s/\r/\n/g" output/"$fname"
echo -e "\nNumber of rows:"
wc -l < "$fname"
echo -e "\nPrinting first 10 rows:"
head "$fname"
echo -e "\nPrinting last 10 rows:"
tail "$fname"
echo -e "\nLooking for Multi-Family:"
cat "$fname" | grep -e Multi-Family
