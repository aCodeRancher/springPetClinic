#!/usr/bin/env bash

COMMIT_MESSAGE="$1"

if [[ $# -eq 0 && -z $COMMIT_MESSAGE ]]
then
    echo "No commit message supplied"
	exit 1
else
	echo \"$COMMIT_MESSAGE\"
	git status
	git add .
	git commit -m '$COMMIT_MESSAGE'
	git push
fi
