#!/bin/bash

RED="\033[0;31m"
GREEN="\033[0;32m"
NC="\033[0m"
    
if [[ -z $2 ]]; then
    fout="Output";
else
    fout=$2;
fi

if [[ -r "${fout}.java" ]]; then
    echo -n "File ${fout}.java already exists. Removing... "
    rm "${fout}.java"
    echo -e "${GREEN}DONE${NC}"
fi

echo "Building TabLan.g4 & ReadCsvFile.g4 languages... "
cd ../src
antlr4-build >/dev/null 2>&1 # O build não leva argumentos, por isso se calhar não vai ser preciso 2 echos para cada linguagem
echo -e "${GREEN}DONE${NC}"