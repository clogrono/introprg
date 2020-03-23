#! /bin/bash

# Aquest programa realitza els tests d'E/S d'un exercici


current=$(dirname "$0")
if [ ! -f "$current/programname" ];
then
    echo
    echo "Error"
    echo "====="
    echo "Problemes amb la teva còpia del test. Considera recuperar l'original"
    exit
fi

programname=$(cat $current/programname)
if [ ! -f $programname ];
then
    echo
    echo "Error"
    echo "====="
    echo "No es troba el programa $programname"
    echo "Assegura't que has posat el nom correcte al teu programa"
    echo
    exit
fi

programa=${programname%%.*}
if [ ! -f "$programa.class" ];
then
    echo "Comprova si has compilat $programa.java"
    exit 1
fi

if [ "$programa.java" -nt "$programa.class" ];
then
    echo "Comprova si has recompilat $programa.java després de modificar-lo"
    exit 1
fi


bash $current/test_junit.sh TestExercise $1 && \
echo "El programa $programname ha passat totes les proves"


