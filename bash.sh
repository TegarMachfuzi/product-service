#!/bin/bash


  filesCommit=0
 read -p "Enter commit message: " COMMIT_MESSAGE

 if [ -z "$COMMIT_MESSAGE" ]; then
   echo "Error: Commit message cannot be empty."
   exit 1
 fi

  git add .
  echo "Perubahan ditambahkan"
  echo ""

  filesCommit=$(git diff --cached --numstat | wc -l)

  git commit -m "$COMMIT_MESSAGE"
  echo "Berhasil Commit : $COMMIT_MESSAGE"
  echo ""
  ((filesCommit))
  if [[ "$filesCommit" -ge 0 ]]; then
      git push origin master
      echo
      echo "#############################################"
      echo "Pushed successfully; $filesCommit files"
      echo "#############################################"
  fi