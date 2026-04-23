# GUIDE FRONTEND - PADELPLAY

Ce document sert de feuille de route pour construire tout le frontend Angular connecte au backend Spring Boot, en mode etape par etape.

---

## 1) Objectif du frontend

Construire une application frontend:
- separee du backend
- connectee a l API REST existante
- responsive (mobile/tablette/desktop)
- simple a utiliser
- testee

Technos cible:
- Angular 20+
- TailwindCSS
- Angular Material (recommande)

---

## 2) Workflow de travail impose

Pour chaque etape:
1. Creer une Issue
2. Creer une branche dediee
3. Developper
4. Tester
5. Commit
6. Ouvrir PR
7. Merger

Convention de branche:
- `feature/frontend-setup`
- `feature/auth-admin`
- `feature/membre-identification`
- etc.

Convention commit:
- `feat: ...`
- `fix: ...`
- `refactor: ...`
- `test: ...`
- `docs: ...`

---

## 3) Plan global des etapes

### ETAPE 1 - Setup frontend
Issue: `#1 Setup Angular + Tailwind + Material`
Branche: `feature/frontend-setup`

A faire:
- Creer projet Angular dans `frontend/`
- Installer TailwindCSS
- Installer Angular Material
- Poser structure `core/shared/features`
- Configurer routing de base
- Configurer environments
- Configurer proxy API vers backend
- Creer layout global (header + shell)

Definition of Done:
- `npm start` lance sans erreur
- page d accueil visible
- style Tailwind + Material actifs
- appel test API possible via proxy

---

### ETAPE 2 - Authentification admin JWT
Issue: `#2 Login admin + guard + interceptor`
Branche: `feature/auth-admin`

A faire:
- Page `admin/login`
- Service login (`POST /api/auth/login`)
- Stockage token JWT
- Interceptor Authorization Bearer
- Guard routes admin
- Gestion role `GLOBAL` et `SITE`
- Logout

Definition of Done:
- login admin fonctionne
- routes admin protegees
- token envoye sur endpoints securises

---

### ETAPE 3 - Identification membre (matricule)
Issue: `#3 Entree membre par matricule`
Branche: `feature/membre-identification`

A faire:
- Ecran identification membre
- Appel `GET /api/membres/matricule/{matricule}`
- Stockage session membre (sans mot de passe)
- Guard membre
- Page profil membre (type, site, solde, penalite)

Definition of Done:
- membre peut entrer avec matricule
- informations membre affichees
- navigation membre protegee

---

### ETAPE 4 - Matchs publics + creation match
Issue: `#4 Ecrans matchs membre`
Branche: `feature/membre-matchs-publics`

A faire:
- Liste matchs publics (`GET /api/matches/public`)
- Filtres (site, date)
- Rejoindre match (reservation)
- Form creation match public/prive
- Support regles metier visibles dans UI

Definition of Done:
- membre voit les matchs publics
- membre peut rejoindre un match
- membre peut creer un match
- erreurs metier backend correctement affichees

---

### ETAPE 5 - Reservations et paiements membre
Issue: `#5 Mes reservations + mes paiements`
Branche: `feature/membre-reservations`

A faire:
- Ecran mes reservations
- Ecran mes paiements
- Action payer reservation
- Statuts visuels (en attente, paye, rembourse, annule)
- feedback utilisateur (snackbar/toast)

Definition of Done:
- paiement reservation fonctionnel
- statuts synchronises avec backend
- historique affichable

---

### ETAPE 6 - Admin dashboard et stats
Issue: `#6 Dashboard admin`
Branche: `feature/admin-dashboard`

A faire:
- Dashboard KPI (membres, matchs, reservations, CA)
- Vue par site
- Graphiques simples (optionnel)
- Zone admin responsive

Definition of Done:
- admin voit KPI principaux
- filtre par site/role effectif

---

### ETAPE 7 - Admin gestion (CRUD)
Issue: `#7 Gestion membres, sites, terrains, matchs`
Branche: `feature/admin-management`

A faire:
- CRUD membres
- CRUD sites
- CRUD terrains
- Vue matchs admin + actions (ex: conversion public)

Definition of Done:
- operations admin principales disponibles
- role SITE limite au site associe

---

### ETAPE 8 - Tests frontend
Issue: `#8 Tests unitaires frontend`
Branche: `feature/frontend-tests`

A faire:
- Tests services API
- Tests composants critiques
- Tests guards/interceptor
- Commande test documentee

Definition of Done:
- suite de tests passe localement
- couverture utile sur parcours critiques

---

### ETAPE 9 - Documentation finale exploitation
Issue: `#9 README frontend + runbook`
Branche: `feature/frontend-docs`

A faire:
- README frontend complet
- prerequis
- commandes install/run/test
- variables d environnement
- points de depannage

Definition of Done:
- un autre dev peut lancer le frontend sans aide

---

## 4) Structure cible frontend

```text
frontend/
  src/
    app/
      core/
        api/
        auth/
        guards/
        interceptors/
        services/
      shared/
        components/
        models/
        pipes/
        utils/
      features/
        member/
          pages/
          components/
          services/
        admin/
          pages/
          components/
          services/
      app.routes.ts
      app.config.ts
    environments/
      environment.ts
      environment.development.ts
  proxy.conf.json
  tailwind.config.js
  postcss.config.js
```

---

## 5) Mapping API a couvrir dans le frontend

Auth:
- `POST /api/auth/login`

Membres:
- `GET /api/membres`
- `GET /api/membres/{id}`
- `GET /api/membres/matricule/{matricule}`
- `GET /api/membres/{id}/penalty`
- `GET /api/membres/{id}/balance`
- `POST /api/membres`
- `PUT /api/membres/{id}`
- `DELETE /api/membres/{id}`

Matchs:
- `GET /api/matches`
- `GET /api/matches/{id}`
- `GET /api/matches/public`
- `GET /api/matches/site/{siteId}`
- `GET /api/matches/organisateur/{organisateurId}`
- `POST /api/matches`
- `PATCH /api/matches/{id}/convert-public`

Reservations:
- `GET /api/reservations/{id}`
- `GET /api/reservations/match/{matchId}`
- `GET /api/reservations/membre/{membreId}`
- `POST /api/reservations`
- `PATCH /api/reservations/{id}/cancel`

Paiements:
- `GET /api/paiements/{id}`
- `GET /api/paiements/reservation/{reservationId}`
- `GET /api/paiements/membre/{membreId}`
- `POST /api/paiements/reservation/{reservationId}/membre/{membreId}`

Sites:
- `GET /api/sites`
- `GET /api/sites/{id}`
- `POST /api/sites`
- `PUT /api/sites/{id}`
- `DELETE /api/sites/{id}`

Terrains:
- `GET /api/terrains`
- `GET /api/terrains/{id}`
- `GET /api/terrains/site/{siteId}`
- `POST /api/terrains`
- `PUT /api/terrains/{id}`
- `DELETE /api/terrains/{id}`

---

## 6) Commandes standards (frontend)

```powershell
cd frontend
npm install
npm start
```

```powershell
cd frontend
npm test
```

---

## 7) Regles UX/UI minimales

- UI claire et simple
- responsive mobile/tablette
- chargements visibles (spinners/skeletons)
- erreurs lisibles (pas de crash brut)
- confirmations apres actions importantes

---

## 8) Checklist PR pour chaque etape

Avant PR, verifier:
- [ ] build frontend ok
- [ ] tests frontend ok (si concernes)
- [ ] lint/format ok
- [ ] appels API verifies
- [ ] gestion erreurs presente
- [ ] responsive verifie
- [ ] README mis a jour si necessaire

Template PR:
- Contexte
- Changements
- Captures ecran
- Comment tester
- Risques connus

---

## 9) Mode de collaboration avec l assistant

Tu envoies:
- `suivant` -> je lance l etape suivante
- ou `etape X` -> je fais exactement cette etape

Pour chaque etape, je te fournis:
1. Issue proposee (titre + description)
2. Nom de branche
3. Liste des fichiers modifies
4. Code complet
5. Commandes test
6. Message de commit recommande
7. Texte PR recommande

---

## 10) Prochaine action

Commande utilisateur attendue: `suivant`

A la prochaine etape, on lance ETAPE 1 (`feature/frontend-setup`).
