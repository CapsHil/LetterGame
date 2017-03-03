# Letter Game
## INF4041 - ESIEA

Build command
`mvn package`

Run application command
`java -cp target/LetterGame-1.0.0-SNAPSHOT.jar fr.esiea.raby_ambassa.game.Application`

Run test command
`mvn test`

To build & run the project easily you can also use `run.sh`

You can add some log, change log level to 'debug' or 'verbose' ('silent' for nothing)


------------

Architecture

L'architecture est composé de 5 packages différents :

- fr.esiea.raby_ambassa.dictionnary : Regroupe les classes faisant référence au dictionnaire ou au pot commun de lettre

- fr.esiea.raby_ambassa.player : Regroupe les classes faisant référence aux joueurs (que ce soit pour l'objet Joueur, ou pour la liste des joueurs de la partie)

- fr.esiea.raby_ambassa.utils : Regroupe les différentes classes "outils" nécessaire au bon fonctionnement du jeu (générateur aléatoire de lettre, gestionnaire de log, parser) 

- fr.esiea.raby_ambassa.word : Regroupe les classes faisant référence aux mots (que ce soit pour l'objet Mot, ou pour la liste des mots actuellement sur le board de la partie)

- fr.esiea.raby_ambassa.game : Contient une classe Pot Commun nécessaire au jeu, ainsi que la classe principale permettant de faire tourner le jeu

----------

Principes/Design pattern
 
L'application respecte le Single responsability principle et l'Open/close principle. En effet, chaque class/méthode à une seule et unique responsabilité, ce qui assure d'avoir un découpage du code optimal (il suffit donc de bien découper son code pour le respecter). 
De plus, les class sont totalement fermées à la modification, mais l'extension reste possible pour des améliorations futures. Pour ce faire, nous avons veillez à ne laisser en 'public' seulement les fonctionnalités utiles et qui ne peuvent pas 

Le design pattern Singleton a été utilisé pour les class Dictionnary, PlayerList, WordList et CommonPot, pour la simple et bonne raison qu'il ne doit y avoir qu'une seule et unique instance de ces class. Pour ce faire, tout les constructeur sont passés en `private`, et une instance de la class est créée à l'execution du programme. Il ne reste plus qu'a y acceder via un 'getter'.