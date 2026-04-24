# PadelPlay - README unique

Application fullstack de gestion de padel:
- backend: Spring Boot (Java 21, Maven Wrapper)
- frontend: Angular (Tailwind + Angular Material)
- base locale par défaut: H2 fichier

## 1) Prérequis

- Java 21
- Node.js 20+
- npm

## 2) Structure principale

- `backend/src/` : backend Spring Boot
- `frontend/src/` : frontend Angular
- `backend/pom.xml` : build backend
- `frontend/package.json` : build frontend
- `backend/docker-compose.yml` : stack optionnelle

## 3) Lancer le projet en local

### Backend

```powershell
Set-Location "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)\backend"
.\mvnw.cmd spring-boot:run
```

Backend: `http://localhost:8080`
Swagger: `http://localhost:8080/swagger-ui.html`

### Frontend

```powershell
Set-Location "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)\frontend"
npm install
npm start
```

Frontend: `http://localhost:4200`

Le proxy frontend envoie `/api` vers `http://localhost:8080` (voir `frontend/proxy.conf.json`).

## 4) Compiler

### Backend

```powershell
Set-Location "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)\backend"
.\mvnw.cmd clean compile -DskipTests
```

### Frontend

```powershell
Set-Location "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)\frontend"
npm run build
```

## 5) Comptes de test (seed)

Les administrateurs seedés dans `backend/src/main/java/com/padelPlay/DataInitializer.java`:

- `admin@padel.com` (GLOBAL)
- `admin.lyon@padel.com` (SITE Lyon)
- `admin.paris@padel.com` (SITE Paris)
- mot de passe: `Admin1234!`

Exemples de matricules membre:
- `G1001`, `G1002`
- `S10001`, `S10002`
- `L10001`

## 6) Fonctionnalités principales

Côté membre:
- identification par matricule
- profil membre
- consultation des matchs publics
- création de match public/privé
- réservations et paiements

Côté admin:
- login JWT
- dashboard
- gestion membres, matchs, sites, terrains
- gestion des jours de fermeture

## 7) Dépannage rapide

- Si le frontend ne démarre pas: relancer `npm install` dans `frontend/`.
- Si l'API échoue depuis le frontend: vérifier que le backend tourne sur le port `8080`.
- Si la base semble incohérente: arrêter l'application puis nettoyer `.data/` (attention: perte des données locales).

## 8) Notes

- Ce README est la documentation unique du projet.
- Les anciens guides ont été retirés pour simplifier la maintenance.

