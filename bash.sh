#!/bin/bash

gitAddCommitPush(){
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
    if [ $? -eq 0 ]; then
      echo "Berhasil commit : $COMMIT_MESSAGE"
        echo ""
        else
          echo "Commit gagal."
          exit 1
    fi

#    if [[ "$filesCommit" -ge 0 ]]; then
        git push
        if [ $? -eq 0 ]; then
            echo
                  echo "#############################################"
                  echo "Pushed successfully; $filesCommit files"
                  echo "#############################################"
                  else
                    echo "gagal push"
                    exit 1
        fi
#        else
#          echo "Tidak ada perubahan yang perlu di push"
#    fi
}
gitAddCommitPush
