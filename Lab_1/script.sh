#!/bin/bash

if [ $# -ne 2 ]; then
  echo "Provide 2 parameters: filename and extension"
  exit 1
fi

filename="$1"
new_extension="$2"

if [ ! -f "$filename" ]; then
    echo "File not found: $filename"
    exit 1
fi

extension="${filename##*.}"

if [ "$extension" = "$filename" ]; then
  echo "File '$filename' does not have an extension"
  exit 1
fi

new_filename="${filename%.*}.$new_extension"

mv "$filename" "$new_filename"

echo "File '$filename' is renamed into '$new_filename' with new extension '$new_extension'"
