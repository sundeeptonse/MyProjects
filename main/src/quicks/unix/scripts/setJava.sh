#!/bin/bash

fileName=$HOME/.bash_profile
oldJava=""
newJava='export JAVA_HOME=$(/usr/libexec/java_home) -v'$1
while IFS='' read -r line || [[ -n "$line" ]]; do
    if [[ $line == *"JAVA_HOME"* ]]
    then
        oldJava=$line
    fi
done < $fileName

newJava=$( echo "$newJava" | sed -e 's/\([]*^+\.$[-]\)/\\\1/g' )
oldJava=$( echo "$oldJava" | sed -e 's/\([]*^+\.$[-]\)/\\\1/g' )

echo $oldJava
echo $newJava

sed -i 's/$oldJava/$newJava/g' $fileName