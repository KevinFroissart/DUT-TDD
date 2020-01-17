# TP0 - FooBarQix <!-- omit in toc -->

## Sommaire <!-- omit in toc -->
- [Principe](#principe)
- [Initialisation](#initialisation)
- [A. Entier vers string](#a-entier-vers-string)
- [B. Divisible par 3](#b-divisible-par-3)
- [C. Divisible par 5](#c-divisible-par-5)
- [D. Divisible par 7](#d-divisible-par-7)
- [E. Divisible par au moins 2 nombres parmi 3, 5 et 7](#e-divisible-par-au-moins-2-nombres-parmi-3-5-et-7)
- [F. Contient 3](#f-contient-3)
- [G. Contient 5](#g-contient-5)
- [H. Contient 7](#h-contient-7)
- [I. Contient deux chiffres parmi 3, 5 ou 7](#i-contient-deux-chiffres-parmi-3-5-ou-7)
- [J. Garder une trace des zéros](#j-garder-une-trace-des-zéros)

## Principe

Mettez vous en binôme, vous allez faire du TDD en mode **ping-pong** !

Pour rappel le code en mode ping-pong fonctionne sur le principe suivant :
1. binôme A écrit le test
2. binôme B écrit l'implémentation
3. binôme A restructure le code
4. binôme B écrit le test suivant
5. binôme A écrit l'implémentation
6. etc.

Vous allez implémenter la classe suivante :

``` java
public class FooBarQix {
    public static String compute (Integer entry) {
        ...
    }
}
```

## Initialisation

### configuration de maven

  - s'il n'existe pas déjà créez un dossier ".m2" : `mkdir $HOME/.m2`
  - création du fichier de configuration : `touch $HOME/.m2/settings.xml`
  - avec votre éditeur de texte préféré, mettez ce qu'il y a ci-dessous dans `settings.xml`
  - finalement, vérifiez votre installation : `mvn -version`

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <proxies>
      <proxy>
        <id>proxy</id>
        <active>true</active>
        <protocol>http</protocol>
        <host>cache.univ-lille1.fr</host>
        <port>3128</port>
      </proxy>
    </proxies>
</settings>
```

### Projet

* Demandez à rejoindre le groupe gitlab suivant : https://gitlab.univ-lille.fr/2019-coa-tdd/groupe-[Votre groupe]/
* Créez un projet dans ce groupe, nommé `tp0-nom1-nom2`
* Dans un terminal, créez un workspace pour la coa-tdd `mkdir ~/ws-coa-tdd`
* Clonez le squelette de projet maven `git clone https://gitlab.univ-lille.fr/2019-coa-tdd/maven-skeleton.git ~/ws-coa-tdd/tp0-nom1-nom2`
* Dans un terminal, entrez dans le répertoire `~/ws-coa-tdd/tp0-nom1-nom2`
* Changer l'URL du projet gitlab pour y mettre la votre `git remote set-url origin URL`
* Modifier le fichier `pom.xml` changez le nom du projet dans le fichier pom.xml `sed -i -e 's/maven-skeleton/tp0-nom1-nom2/g' pom.xml`
* Lancez les tests pour vérifier que tout fonctionne `mvn test`
* Ouvrez éclipse `eclipse -data ~/ws-coa-tdd/`
* Importez votre nouveau projet maven à l'aide du menu File > Import : ![](import.png)

Maintenant vous avez tout ce qu'il faut pour commencer à travailler.

## A. Entier vers string

Avec un entier en entrée, la méthode `FooBarQix.compute()` va nous retourner la version `String` par exemple :

| Entrée | Sortie |
|--------|--------|
| 1      | "1"    |
| 31     | "31"   |

### A.1. Codez le premier test

À l'image de la classe ExampleTest, commencez par créer une nouvelle classe FooBarQixTest avec une première méthode de test. Par exemple :

``` java
public class FooBarQixTest {
    @Test
    public void should_return_input_as_string () {
        Assert.assertEquals("1", FooBarQix.compute(1));
    }
}
```

Pour pouvoir lancer le test (et l'observer échouer en rouge), il faut créer une nouvelle classe FooBarQix avec la méthode compute.

``` java
public class FooBarQix {
    public static String compute (Integer entry) {
        return "";
    }
}
```

Lancez maintenant le test :
- soit avec la commande `mvn test` :
- soit dans éclipse avec "clic droit" > "Run as" > "JUnit test"
- soit dans IntelliJ avec <kbd>CTRL</kbd>+<kbd>SHIFT</kbd>+<kbd>F10</kbd>

Vous verrez que le test échoue puisque la méthode FooBarQix::compute retourne une chaîne vide alors que le test s'attend à recevoir la chaîne `"1"`.

### A.2. Codez la première implémentation

L'idée c'est de faire passer le test au vert le plus simplement possible. Par exemple avec le code suivant :

``` java
public class FooBarQix {
    public static String compute (Integer entry) {
        return "1";
    }
}
```

Vérifiez que le test passe correctement. Si tout se passe bien (tests au vert) commitez votre travail.

### A.3. Restructurez le code

Restructurez le code de façon à obtenir un code dont vous êtes fier, avec des méthodes de test explicites, capables de bien exprimer le besoin métier.

Une fois que vous êtes satisfaits de votre travail, commitez et pushez votre code.

### A.4. Itérez

Recommencez la boucle TDD tant que la règle métier n'est pas correctement implémentée : bien qu'on ait un test vert, en réalité on n'a pas encore vraiment implémenté la règle métier.

Il faut donc un 2e tour de boucle dans lequel vous allez :
- écrire un nouveau test (dans la même méthode) qui permette de vérifier la règle métier
- recoder la méthode compute afin de la rendre générique
- restructurer le code

N'oubliez pas les commit/push à chaque étape de cette nouvelle boucle.

## B. Divisible par 3

Si l'entrée est divisible par 3 alors la méthode `FooBarQix.compute()` doit maintenant retourner "Foo".

Exemples :

| Entrée | Sortie |
|--------|--------|
| 6      | "Foo"  |
| 78     | "Foo"  |

Créez une nouvelle méthode de test dans la classe `FooBarQixTest.java` pour tester cette nouvelle fonctionnalité. Réalisez la boucle TDD autant de fois que nécessaire.

Chaque fois que vous abordez la phase de restructuration, posez vous les questions suivantes :
- Sommes-nous fiers de notre code ?
- Avons-nous bien appliqué tous les principes SOLID ?
- Pouvons-nous appliquer un design pattern pour voir s'il serait adapté ?

## C. Divisible par 5

Si l'entrée est divisible par 5 alors la méthode `FooBarQix.compute()` nous retourne "Bar"

Exemples :

| Entrée | Sortie |
|--------|--------|
| 10     | "Bar"  |
| 130    | "Bar"  |

Réalisez la boucle TDD autant de fois que nécessaire.

## D. Divisible par 7

Si l'entrée est divisible par 7 alors la méthode `FooBarQix.compute()` nous retourne "Qix"

Exemples :

| Entrée | Sortie |
|--------|--------|
| 14     | "Qix"  |
| 182    | "Qix"  |

Réalisez la boucle TDD autant de fois que nécessaire.

## E. Divisible par au moins 2 nombres parmi 3, 5 et 7

Si l'entrée est divisible par au moins 2 des nombres 3, 5 ou 7 alors la méthode `FooBarQix.compute()` nous retourne une composition de "Foo", "Bar" ou "Qix" respectant l'ordre "Foo", "Bar", "Qix"

Exemples :

| Entrée | Sortie      |
|--------|-------------|
| 30     | "FooBar"    |
| 70     | "BarQix"    |
| 21     | "FooQix"    |
| 210    | "FooBarQix" |

Réalisez la boucle TDD temps que tous les cas fonctionnels ne sont pas testés.

## F. Contient 3

Si l'entrée contient le chiffre 3 alors la méthode `FooBarQix.compute()` remplace chaque occurrence par "Foo" et supprime les chiffres non remplacés.

Exemples :

| Entrée | Sortie |Commentaire |
|--------|--------|------------|
| 13     | "Foo"  | |
| 3113   | "FooFoo"  ||
| 3      | "FooFoo" | Contient "3" et est divisible par 3|

Réalisez la boucle TDD autant de fois que nécessaire.

## G. Contient 5

Si l'entrée contient le chiffre 5 alors la méthode `FooBarQix.compute()` remplace chaque occurrence par "Bar" et supprime les chiffres non remplacés.

Exemples :

| Entrée | Sortie |
|--------|--------|
| 5111     | "Bar"  |
| 551    | "BarBar"  |

Réalisez la boucle TDD autant de fois que nécessaire.

## H. Contient 7

Si l'entrée contient le chiffre 7 alors la méthode `FooBarQix.compute()` remplace chaque occurrence par "Qix" et supprime les chiffres non remplacés.

Exemples :

| Entrée | Sortie |
|--------|--------|
| 71     | "Qix"    |
| 7724   | "QixQix" |

Réalisez la boucle TDD autant de fois que nécessaire.


## I. Contient deux chiffres parmi 3, 5 ou 7

Si l'entrée contient au moins 2 chiffres parmi 3, 5 ou 7 alors la méthode `FooBarQix.compute()` remplace chaque occurrence de 3, 5 ou 7 par "Foo", "Bar" ou "Qix" en respectant l'ordre et supprime les chiffres non remplacés.

Exemples :

| Entrée | Sortie |
|--------|--------|
| 173    | "QixFoo" |

Réalisez la boucle TDD autant de fois que nécessaire.

## J. Garder une trace des zéros

Si l'entrée contient des "0", les remplacez par des "*"

Exemples :

| Entrée  | Sortie   |
|---------|----------|
| 1703    | "Qix*Foo" |

Réalisez la boucle TDD autant de fois que nécessaire.

## Une solution <!-- omit in toc -->

https://tube.tux.ovh/videos/watch/809a8c8f-1e56-4336-9683-593efbf24bec




# TP1 - Calculatrice à notation polonaise inverse

Mettez-vous en binôme, vous allez faire du TDD en mode ping-pong.

La notation polonaise inverse (Reverse Polish Notation en anglais) également connue sous le nom de notation post-fixée permet d'écrire de façon non ambiguë les formules arithmétiques sans utiliser de parenthèses.

Vous allez implémenter la classe suivante : 

``` java
public class RPNCalculator {
    public static double eval (String expression) {
        ...
    }
}
```

## Initialisation

### configuration de maven

* s'il n'existe pas déjà créez un dossier ".m2" : `mkdir $HOME/.m2`
* création du fichier de configuration : `touch $HOME/.m2/settings.xml`
* avec votre éditeur de texte préféré, mettez ce qu'il y a ci-dessous dans `settings.xml`
* finalement, vérifiez votre installation : `mvn -version`

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <proxies>
      <proxy>
        <id>proxy</id>
        <active>true</active>
        <protocol>http</protocol>
        <host>cache.univ-lille1.fr</host>
        <port>3128</port>
      </proxy>
    </proxies>
</settings>
```

### Projet

* Si ce n'est pas déjà fait, demandez à rejoindre le groupe gitlab suivant : https://gitlab.univ-lille.fr/2019-coa-tdd/groupe-[Votre groupe]/
* Créez un projet dans ce groupe, nommé `tp1-nom1-nom2`
* Dans un terminal, si ce n'est pas déjà fait, créez un workspace pour la coa-tdd `mkdir ~/ws-coa-tdd`
* Clonez le squelette de projet maven `git clone https://gitlab.univ-lille.fr/2019-coa-tdd/maven-skeleton.git ~/ws-coa-tdd/tp1-nom1-nom2`
* Dans un terminal, entrez dans le répertoire `~/ws-coa-tdd/tp1-nom1-nom2`
* Changer l'URL du projet gitlab pour y mettre la votre `git remote set-url origin URL`
* Modifier le fichier `pom.xml` changez le nom du projet dans le fichier pom.xml `sed -i -e 's/maven-skeleton/tp1-nom1-nom2/g' pom.xml`
* Lancez les tests pour vérifier que tout fonctionne `mvn test`
* Ouvrez éclipse `eclipse -data ~/ws-coa-tdd/`
* Importez votre nouveau projet maven à l'aide du menu File > Import.

Une fois arrivé là, prévenir l'enseignant et allez aider les autres binômes. L'objectif est de commencer l'étape d'après tous ensemble.

### Barème de relecture

Dans toute la suite attention de bien suivre la boucle TDD et de faire des commits à la fin de chaque étape, et des push à la fin de chaque boucle. Un git log du projet devrait ressembler à ça :


```
...
efd6601 Add test and impl for minus
b28a944 Refactor tests
b28a944 True implementation for plus
8ab9f43 Add second test for plus
b28a944 Refactor static import in tests
b28a944 Very simple implementation for plus
2530399 Add first test for plus
f9aa3f3 Bootstrap project

```

Nous apporterons une attention toute particulière à la concordance entre les messages de commits, les heures de commits et les contenus des commits.

Pendant la suite du TP, nous allons ajouter un certain nombre de règles très simples permettant d'avoir un code plus propre, le respect des ces règles rentre bien évidemment dans le barème de correction.

Enfin, chaque push va alimenter sonar : https://sonar.tcweb.org/. Sonar est un robot capable de détecter des bugs, des vulnérabilités ainsi que la couverture de code et le pourcentage de code dupliqué. Dans le cadre du TP il est important d'obtenir "A" dans toutes les notes, 100% de couverture de code et 0% de code dupliqué.

## Addition

Avec l'expression suivante en entrée, la méthode `RPNCalculator.eval()` va nous retourner le résultat de l'opération, par exemple :

| Entrée      | Sortie | Notation infixée |
|-------------|--------|------------------|
| 1 1 +       | 2      | 1 + 1            |
| 7 3 +       | 10     | 7 + 3            |
| 9 13 +      | 22     | 9 + 13           |
| 13.9 1.3 +  | 15.2   | 13.9 + 1.3       |

## Soustraction

Avec l'expression suivante en entrée, la méthode `RPNCalculator.eval()` va nous retourner le résultat de l'opération, par exemple :

| Entrée      | Sortie | Notation infixée |
|-------------|--------|------------------|
| 4 1 -       | 3      | 4 - 1            |
| 7 9 -       | -2     | 7 - 9            |
| 139.7 12 -  | 127.7  | 139.7 - 12       |

## De multiples opérations

Avec l'expression suivante en entrée, la méthode `RPNCalculator.eval()` va nous retourner le résultat de l'opération, par exemple :

| Entrée      | Sortie | Notation infixée |
|-------------|--------|------------------|
| 1 2 + 6 +   | 9      | ( 1 + 2 ) + 6    |
| 7 3 5 - +   | 5     | 7 + (3 - 5)      |

## Multiplication

Avec l'expression suivante en entrée, la méthode `RPNCalculator.eval()` va nous retourner le résultat de l'opération, par exemple :

| Entrée      | Sortie | Notation infixée |
|-------------|--------|------------------|
| 2 2 *       | 4      | 2 * 2            |
| 9 0.5 *     | 4.5    | 9 * 0.5          |
| 1359 1.1 *  | 1494.9 | 1359 * 1.1       |
| 7 3 * 4 +   | 25     | (7 * 3) + 4      |
| 7 3 4 * +   | 19     | 7 + (3 * 4)      |

## Division

Avec l'expression suivante en entrée, la méthode `RPNCalculator.eval()` va nous retourner le résultat de l'opération, par exemple :

| Entrée      | Sortie    | Notation infixée |
|-------------|-----------|------------------|
| 2 4 /       | 0.5       | 2 / 4            |
| 19.4 3 /    | 6.4666... | 19.4 / 3         |
| 18 3 / 2 +  | 8         | 18 / 3 + 2       |
| 18 3 2 / -  | 16.5      | 18 - (3 / 2)     |

## Racine carrée

Ajouter l'opérateur SQRT qui calcul la racine carrée de l'opérande.

## Trigonométrie

Ajouter les opérateurs SIN, COS et TAN qui calcul respectivement le sinus, le cosinus et la tangente de l'opérande.

## Puissance

Ajouter l'opérateur ^ qui calcule la puissance des 2 opérandes


| Entrée      | Sortie | Notation infixée  |
|-------------|--------|-------------------|
| 2 3 ^       | 8      | 2 ^ 3 = 2 * 2 * 2 |

## Puissances itérées de Knuth

Ajouter l'opérateur ↑↑ qui calcule la puissance itérée sur les 2 opérandes

Pour obtenir le caractère ↑ faire CTRL + MAJ + U puis 2191 puis ENTRÉE


| Entrée      | Sortie | Notation infixée       |
|-------------|--------|------------------------|
| 2 4 ↑↑      | 65536  | 2 ↑↑ 4 = 2 ^ 2 ^ 2 ^ 2 |


# Barème de correction

Comme une dictée, la copie démarre avec 20 points. Chaque erreur enlève des points.

Dans Sonar :
* -3 par bug ou vulnérabilité bloquante
* -2 par bug ou vulnérabilité critique
* -1 par bug ou vulnérabilité majeur
* -0.5 par bug ou vulnérabilité pour tous les autres types.
* -0.5 par pourcentage de code non couvert
* -0.5 par pourcentage de code dupliqué

L'ensemble du code doit respecter des règles que nous avons eues (SOLID, lisibilité, DRY, KISS, YAGNI, etc.). En fonction de ces règles, estimez la note du code que vous relisez.

Un test rouge : -1 point

Je vous invite à ajouter vos propres tests pour vérifier que le code respecte bien le besoin métier. Attention le but est bien d'évaluer la qualité du code et pas sa complétude en rapport à toutes les questions. Si vous avez des tests correspondant aux questions traités par les étudiants que vous corrigez qui ne passent pas vous pouvez enlever des points.

Pour vérifier que la boucle TDD a bien été respectée, vous avez 2 outils à votre disposition :
* `git log --oneline --decorate --graph --all --format="%h %C(auto,blue)%ad%C(auto,black) %s"` qui permet de lister tous les commits avec l'heure et le commentaire
* `for commit in $(git log --reverse --pretty=format:%H); do git checkout $commit; git show --stat $commit; read; done` qui rejoue la liste de tous les commit 1 à 1 en affichant quelques éléments. Pour passer d'un commit à l'autre, il faut sortir du git show et valider avec la touche entrée.

À chaque non respect de la boucle TDD -1 point s'impose.

Merci de remplir un fichier notes.md à la racine du projet que vous corrigez avec le contenu suivant :


```markdown
| Correcteur        | Note /20 | Commentaire |
|-------------------|----------|-------------|
| Nom               | XX       |             |
| Nom               | XX       |             |
```

Je vais moi aussi noter votre code, si je trouve des notes trop gentilles ou trop sévère c'est 0 aux 2 copies.

## Une solution <!-- omit in toc -->

https://tube.tux.ovh/videos/watch/c932efda-7880-442a-8482-b4d56ebad7d6

## Rappel des règles de clean code vue pendant le TP

* pas de méthode de plus de 10 lignes
* nommage correct des variables et des méthodes : on comprend à quoi elles servent à la lecture et il n'y a pas d'abréviation.
* pas plus de 3 indentations par méthode
* pas de classe de plus de 50 lignes
* pas de commentaire, on comprend le code à la première lecture
* pas de répétition (DRY)
* le code est le plus simple possible : si je peux enlever du code sans casser les tests c'est que je n'ai pas fini ma simplification
* Pas de "magic numbers", des nombre ou des Strings qui sortent de nulle part.
* Max 2 paramètres par méthode
* Pas plus d'un point par ligne (cf. notation fluent)




# TP2 - Bowling Game

Pour ce TP, vous allez faire du TDD seul.

Il existe un très grand nombre d'implémentations de cet exercice sur internet, vous aider de l'une d'entre elle est probablement la pire des solutions pour apprendre quelque chose aujourd'hui.

    1 4 | 4 5 | 6 / | 5 / |   X | 0 1 | 7 / | 6 / |   X | 2 / 6 |
    5   | 14  | 29  | 49  | 60  | 61  | 77  | 97  | 117 | 133   |

Une partie de bowling compte dix carreaux (ou 10 frames). Chaque joueur lance deux boules à chaque carreau, sauf en cas d'abat (strike). Un abat consiste à faire tomber les dix quilles avec la première boule. La réserve (spare) consiste à faire tomber les dix quilles avec les deux tirs consécutifs du carreau.

* En cas d'abat, indiqué par un « X » : 10 + nombre de quilles abattues après les deux lancers suivants.
* En cas de « réserve », indiquée par le nombre de quilles renversées au premier lancer, suivi d’un « / », par exemple « 8 / ») : 10 + nombre de quilles abattues au lancer suivant.
* Trou (ou jeu ouvert) : nombre de quilles abattues.
* Le dixième jeu est particulier : en cas d'abat au premier lancer, deux lancers supplémentaires sont accordés. En cas de réalisation d’une réserve, un lancer supplémentaire est accordé.

Ainsi, la marque parfaite est de 300 points, pour douze abats consécutifs.

## Rappel des règles de clean code

- pas de méthode de plus de 10 lignes
- nommage correct des variables et des méthodes : on comprend à quoi elles servent à la lecture et il n'y a pas d'abréviation.
- pas plus de 3 indentations par méthode
- pas de classe de plus de 50 lignes
- pas de commentaire, on comprend le code à la première lecture
- pas de répétition (DRY)
- le code est le plus simple possible : si je peux enlever du code sans casser les tests c'est que je n'ai pas fini ma simplification
- Pas de "magic numbers", des nombre ou des Strings qui sortent de nulle part.
- Max 2 paramètres par méthode
- Pas plus d'un point par ligne (cf. notation fluent)

## Initialisation

### configuration de maven

* s'il n'existe pas déjà créez un dossier ".m2" : `mkdir $HOME/.m2`
* création du fichier de configuration : `touch $HOME/.m2/settings.xml`
* avec votre éditeur de texte préféré, mettez ce qu'il y a ci-dessous dans `settings.xml`
* finalement, vérifiez votre installation : `mvn -version`

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <proxies>
      <proxy>
        <id>proxy</id>
        <active>true</active>
        <protocol>http</protocol>
        <host>cache.univ-lille1.fr</host>
        <port>3128</port>
      </proxy>
    </proxies>
</settings>
```

### Projet

* Si ce n'est pas déjà fait, demandez à rejoindre le groupe gitlab suivant : https://gitlab.univ-lille.fr/2019-coa-tdd/groupe-[Votre groupe]/
* Créez un projet dans ce groupe, nommé `tp2-nom`
* Dans un terminal, si ce n'est pas déjà fait, créez un workspace pour la coa-tdd `mkdir ~/ws-coa-tdd`
* Clonez le squelette de projet maven `git clone https://gitlab.univ-lille.fr/2019-coa-tdd/maven-skeleton.git ~/ws-coa-tdd/tp2-nom`
* Dans un terminal, entrez dans le répertoire `~/ws-coa-tdd/tp2-nom`
* Changer l'URL du projet gitlab pour y mettre la votre `git remote set-url origin URL`
* Modifier le fichier `pom.xml` changez le nom du projet dans le fichier pom.xml `sed -i -e 's/maven-skeleton/tp2-nom/g' pom.xml`
* Lancez les tests pour vérifier que tout fonctionne `mvn test`
* Ouvrez éclipse `eclipse -data ~/ws-coa-tdd/`
* Importez votre nouveau projet maven à l'aide du menu File > Import.

## Première étape

Écrire une classe BowlingGame avec 2 méthodes :
- roll(pins : int) qui est appelé à chaque lancé. L'argument est le nombre de quilles abattues durant le lancé.
- score() : int qui retourne le nombre de points courant de la partie.

``` java
public class BowlingGame {
    public void roll (int pins) {
        ...
    }

    public int score () {
        ...
    }
}
```

Tous les tests d'acceptances prendront en entrée la réprésentation ASCII de la partie. Nous pourrions avoir par exemple :

``` java
public class BowlingGameTest {
    @Test
    public void score_should_return_the_sum_of_knocked_pins () {
        BowlingGame game = playOnNewGame("7 2 | 4 4 | 1 3 |");
        assertEquals(21, game.score());
    }

    @Test
    @Ignore
    public void score_should_take_the_spare_bonus () {
        BowlingGame game = playOnNewGame("6 / | 4 ");
        assertEquals(18, game.score());
    }

    ...

}
```

## Seconde étape

Ajouter la méthode toString() qui retourne la représentation ASCII de la partie en cours comme ci dessus.

``` java
public class BowlingGame {
    public String toString () {
        ...
    }
}
```




# TP3 - Des nombres et des mots

Pour ce dernier TP, vous allez faire du TDD seul.

L'objectif est de réaliser un convertisseur de nombres en lettres.

Vous allez implémenter la classe suivante : 

``` java
public class Numeral {
    public Numeral (String number) {
        ...
    }

    public String toLetters () {
        ...
    }
}
```

## Initialisation

### configuration de maven

Si ça n'a pas été fait, voir le [TP0](https://gitlab.univ-lille.fr/2019-coa-tdd/tp0/)

### Projet

Comme pour le [TP0](https://gitlab.univ-lille.fr/2019-coa-tdd/tp0/), créez un projet gitlab `tp3-nom` et importez le dans votre éditeur préféré.

Maintenant vous avez tout ce qu'il faut pour commencer à travailler.


### Barème de relecture

Dans toute la suite attention de bien suivre la boucle TDD et de faire des commits à la fin de chaque étape, et des push à la fin de chaque boucle. Un git log du projet devrait ressembler à ça :


```
...
b28a944 Refactor tests
b28a944 Impl addition
8ab9f43 Add second test for addition
efd6601 Green bar for first addition
2530399 Add first test for addition
f9aa3f3 Bootstrap project

```

Nous apporterons une attention toute particulière à la concordance entre les messages de commits, les heures de commits et les contenues des commits.

Les règles de code propre à respecter sont toujours les mêmes :

* pas de méthode de plus de 10 lignes
* nommage correct des variables et des méthodes : on comprend à quoi elles servent à la lecture et il n'y a pas d'abréviation.
* pas plus de 3 indentations par méthode
* pas de classe de plus de 50 lignes
* pas de commentaire, on comprend le code à la première lecture
* pas de répétition (DRY)
* le code est le plus simple possible (KISS, YAGNI) : si je peux enlever du code sans casser les tests c'est que je n'ai pas fini ma simplification
* Pas de "magic numbers", des nombre ou des Strings qui ne sortent de nulle part.
* Max 2 paramètres par méthode
* Pas plus d'un point par ligne (cf. notation fluent)
* Toutes les règles que vous avez rencontrées depuis 2 ans.

Enfin, chaque push va alimenter sonar : https://sonar.tcweb.org/. Sonar est un robot capable de détecter des bugs, des vulnérabilités ainsi que la couverture de code et le pourcentage de code dupliqué. Dans le cadre du TP il est important d'obtenir A dans toutes les notes, 100% de couverture de code et 0% de code dupliqué.

Pour finir, il va sans dire que l'objectif est d'aller le plus loin possible dans le sujet.

## Les Unités

En initialisant notre objet Numeral avec une string d'un chiffre, il est possible d'obtenir la version écrite en lettres de ce chiffre commençant par une majuscule.

Par exemple :

| Entrée      | Sortie |
|-------------|--------|
| 1           | Un     |
| 7           | Sept   |


## Première dizaine

En initialisant notre objet Numeral avec une string de deux chiffres, il est possible d'obtenir la version écrite en lettres de ce chiffre commençant par une majuscule.

Par exemple :

| Entrée      | Sortie |
|-------------|--------|
| 10          | Dix    |
| 18          | Dix-huit |

## Seconde dizaine

En initialisant notre objet Numeral avec une string de deux chiffres, il est possible d'obtenir la version écrite en lettres de ce chiffre commençant par une majuscule.

Par exemple :

| Entrée      | Sortie |
|-------------|--------|
| 20          | Vingt    |
| 21          | Vingt et un |

## Autres dizaines

En initialisant notre objet Numeral avec une string de deux chiffres, il est possible d'obtenir la version écrite en lettres de ce chiffre commençant par une majuscule.

Par exemple :

| Entrée      | Sortie |
|-------------|--------|
| 39          | Trente-neuf        |
| 96          | Quatre-vingt-seize |

## Centaines

En initialisant notre objet Numeral avec une string de trois chiffres, il est possible d'obtenir la version écrite en lettres de ce chiffre commençant par une majuscule.

Par exemple :

| Entrée      | Sortie |
|-------------|--------|
| 100         | Cent               |
| 200         | Deux cents               |
| 375         | Trois cent soixante-quinze |

## Des euros

En initialisant notre objet Numeral avec une string décrivant un prix en euro, il est possible d'obtenir la version écrite en lettres de ce prix commençant par une majuscule.
En Français, le symbole monétaire se place après tous les chiffres séparés par une espace.

Par exemple :

| Entrée      | Sortie |
|-------------|--------|
| 1 €         | Un euro              |
| 845 €       | Huit cent quarante-cinq euros |

## Des milles

En initialisant notre objet Numeral avec une string, il est possible d'obtenir la version écrite en lettres de ce chiffre ou du prix commençant par une majuscule.

Par exemple :

| Entrée      | Sortie |
|-------------|--------|
| 1000        | Mille              |
| 4000        | Quatre mille             |
| 5668 €      | Cinq mille six cents soixante-huit euros |

# Plus d'unités

* Ajouter la gestion d'autres monnaie comme le dollar, la livre ou le yen.
* Ajouter la gestion des unités métriques (km, m, cm, ...)

# Des nombres de plus en plus grand

* Ajouter la gestion des nombres jusqu'au milliard.
* Ajouter la gestion des quintillions.

# Affichage en chiffres

Ajouter la méthode `public String toFigures()` qui retourne le nombre formaté en respectant les règles typographique françaises (regroupement des chiffres par 3 séparés par des espaces).

# L'opération inverse

Ajouter la méthode `public Numeral fromLetters(String number)` qui permet de parser un nombre écrit en lettre.

# Barème de correction

Comme une dictée, la copie démarre avec 20 points. Chaque erreur enlève des points.

Pour garder les 20 points, le programme doit au moins savoir convertire jusqu'à 999. À partir de la gestion des euros, ce sont donc des questions bonus.

Dans Sonar :
* -3 par bug ou vulnérabilité bloquante
* -2 par bug ou vulnérabilité critique
* -1 par bug ou vulnérabilité majeure
* -0.5 par bug ou vulnérabilité pour tous les autres types.
* -0.5 par pourcentage de code non couvert
* -0.5 par pourcentage de code dupliqué

L'ensemble du code doit respecter des règles que nous avons eu (SOLID, lisibilité, DRY, KISS, YAGNI, etc.) en fonction de ces règles, estimez la note du code que vous relisez.

Un test rouge : -1 point

Je vous invite à ajouter vos propres tests pour vérifier que le code respecte bien le besoin métier. Attention le but est bien d'évaluer la qualité du code et pas sa complétude en rapport à toutes les questions. Si vous avez des tests correspondant aux questions traitées par les étudiants que vous corrigez qui ne passent pas vous pouvez enlever des points.

Pour vérifier que la boucle TDD a bien été respectée, vous avez 2 outils à votre disposition :
* `git log --oneline --decorate --graph --all --format="%h %Cblue%ad% %C(auto) %s"` qui permet de lister tous les commits avec l'heure et le commentaire
* `for commit in $(git log --reverse --pretty=format:%H); do git checkout $commit; git show --stat $commit; read; done` qui rejoue la liste de tous les commit 1 à 1 en affichant quelques éléments. Pour passer d'un commit à l'autre, il faut sortir du git show et valider avec la touche entrée.
* Pour revenir au dernier commit `git checkout master`

À chaque non respect de la boucle TDD -1 point s'impose.

Merci de remplir un fichier `notes.md` à la racine du projet que vous corrigez avec le contenu suivant :
Ajouter la gestion des quintillions.


```markdown
| Correcteur        | Note /20 |
|-------------------|----------|
| Nom               | XX       |
| Nom               | XX       |

# Commentaires

## Nom1

* item

## Nom2

* item

```

Je vais moi aussi noter votre code, si je trouve des notes trop gentilles ou trop sévère c'est 0 aux 2 copies.