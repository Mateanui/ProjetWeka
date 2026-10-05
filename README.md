# ProjetWeka

Academic Java project for comparing classification algorithms using the Weka machine-learning toolkit.

## About

This project explores several classification algorithms against datasets in ARFF format.

The application includes multiple classification approaches, including:

- J48
- K-Nearest Neighbours (KNN)
- Random Forest
- AdaBoostM1

The repository also contains a collection of ARFF datasets used with the application.

## Project structure

- `src/weka/algorithme` — classification algorithm components
- `src/weka/controleurs` — application controllers
- `src/weka/vue` — user-interface components
- `src/weka/main` — application entry point
- `data` — ARFF datasets used by the application

## Technologies

- Java
- Weka
- ARFF

## Running the application

The packaged application can be launched with:

```bash
java -jar projetWeka.jar
