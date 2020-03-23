#! /bin/bash
# Aquest programa realitza els tests d'E/S d'un exercici

# Check that $1 contains the name of the program under test
if [ -z "$1" ];
then
    echo "Ús: $0 NomDelProgramaATestejar"
    exit 1
fi

current=$(dirname "$0")
#diffoptions="-EZbB"
programa=$1
tmpfile=$(mktemp)
errors=0
for filein in $current/testfile*.txt;
do
    filename=$(basename -- $filein)
    filenumber=${filename##testfile}
    testnumber=${filenumber%.*}
    fileout=$current/expected$filenumber
    java $programa < $filein &> $tmpfile
    diff $diffoptions $tmpfile $fileout &> /dev/null
    if [ $? -ne "0" ];
    then
        errors=1
        echo "Test nr. $testnumber: Error"
        echo
        echo "Entrada"
        echo "======="
        cat $filein
        echo
        echo "Sortida esperada"
        echo "================"
        cat $fileout
        echo
        echo "Sortida trobada"
        echo "==============="
        cat $tmpfile
        echo
        echo "Diferència"
        echo "=========="
        diff $diffoptions $fileout $tmpfile
        echo
        break
    fi
done
if [ "$errors" -ne "0" ];
then
    rm $tmpfile
    exit 1
fi
