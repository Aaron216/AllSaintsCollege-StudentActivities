# All Saints' College
## Student Activites

This program will take a csv in the following format

| Firstname | Surname | Activity |
| Joe       | Smith   | Sports   |
| Joe       | Smith   | Chess    |
| Tilly     | Iris    | Drama    |


and convert it to the following format

| Firstname | Surname | Details |       |
| Joe       | Smith   | Sports  | Chess |
| Tilly     | Iris    | Drama   |       |

### Usage
    javac *.java
    java Main .\InputFile.csv .\OutputFile.csv