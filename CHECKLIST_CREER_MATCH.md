# ✅ Checklist finale - Créer un match

Suivez cette checklist étape par étape pour créer un match sans erreur.

---

## 🔴 AVANT DE COMMENCER

### 1️⃣ Vérifier que les serveurs fonctionnent

**Backend** - Terminal 1 :
```powershell
cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)"
.\mvnw spring-boot:run
```
✅ Attendez : `APPLICATION STARTED` ou `Tomcat started on port 8080`

**Frontend** - Terminal 2 :
```powershell
cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)\frontend"
npm start
```
✅ Attendez : `Application is running at http://localhost:4200`

### 2️⃣ Ouvrir le navigateur
```
http://localhost:4200
```

---

## 🟡 ÉTAPE 1 : SE CONNECTER

- [ ] Allez à **"Espace membre"** (bouton en haut)
- [ ] Entrez un **matricule valide** :
  - `G1001` (GLOBAL - 21 jours d'avance requis)
  - `G1002` (GLOBAL - 21 jours d'avance requis)
  - `S10001` (SITE - 14 jours d'avance requis)
  - `S10002` (SITE - 14 jours d'avance requis)
  - `L10001` (LIBRE - 5 jours d'avance requis)
- [ ] Cliquez **"🎾 Accéder à mon espace"**
- [ ] Vous êtes redirigé vers **"Profil"** ✅

---

## 🟡 ÉTAPE 2 : VÉRIFIER VOTRE PROFIL

Allez à **"Mon profil membre"** et vérifiez :

- [ ] **Nom** : affiché correctement
- [ ] **Type** : GLOBAL / SITE / LIBRE
- [ ] **Solde** : **0 EUR** (sinon vous avez une dette)
- [ ] **Pénalité active** : **Non** (sinon attendez)

❌ **Si Solde ≠ 0 EUR ou Pénalité = Oui** :
→ Allez à **"Mes paiements"** et réglez vos dettes (bouton **"Payer"**)

---

## 🟢 ÉTAPE 3 : CRÉER UN MATCH

### 3A - Accéder au formulaire
- [ ] Cliquez sur **"🎾 Match PUBLIC"** (en haut, couleur verte) ou
- [ ] Allez au bloc **"Créer un match rapidement"** sur le profil et cliquez **"Créer match PUBLIC"**

### 3B - Remplir le formulaire

| Champ | Valeur | Exemple |
|-------|--------|---------|
| **Site** | Choisir | Padel Club Lyon |
| **Terrain** | Auto-rempli après site | Court A |
| **Date** | Futur + délai requis | 2026-05-08 ou plus |
| **Heure début** | 8h-22h (Lyon) ou 7h-23h (Paris) | 09:00 |
| **Type de match** | PUBLIC | PUBLIC |

**Calcul de la date minimale** :
- Aujourd'hui = 24/04/2026
- Si **LIBRE** : +5 jours = 29/04/2026 ✅
- Si **SITE** : +14 jours = 08/05/2026 ✅
- Si **GLOBAL** : +21 jours = 15/05/2026 ✅

Le formulaire affiche : `Première date disponible selon votre profil: YYYY-MM-DD`

- [ ] Remplissez **tous les champs**
- [ ] Date ≥ date minimale affichée
- [ ] Heure entre 8h-22h (Lyon) ou 7h-23h (Paris)

### 3C - Créer
- [ ] Cliquez **"Creer le match"**

---

## 🔵 ÉTAPE 4 : ANALYSER L'ERREUR (SI ELLE SURVIENT)

Si l'erreur n'a pas disparu après correction, ouvrez **F12 → Console** :

### Cherchez ces lignes (faites Ctrl+F pour chercher) :

```
Creating match with payload:
```

Si elle n'existe **pas** :
→ Le formulaire est invalide. Vérifiez les champs rouges.

Si elle **existe**, cherchez ensuite :

```
❌ Erreur :
```

Le **message exact** après "Erreur :" est le problème.

**Exemples** :
- `❌ Erreur : Member has an outstanding balance...` → Allez payer
- `❌ Erreur : must book at least 21 days...` → Date trop proche
- `❌ Erreur : slot is already booked...` → Heure/jour occupé

---

## ✅ ÉTAPE 5 : SUCCÈS

Si la création fonctionne :

1. **Message vert** : "Match créé avec succès"
2. **Redirection** : Vers **"Mes réservations"**
3. **Vous verrez** :
   - Le match que vous avez créé dans "Mes matchs organisés"
   - Votre réservation dans la liste ci-dessous

---

## 📋 Tableau d'erreurs courantes

| Erreur | Cause | Solution |
|--------|-------|----------|
| `outstanding balance` | Solde impayé | Allez à **Mes paiements** et cliquez **Payer** |
| `active penalty` | Pénalité active | Attendez que la pénalité expire (aucune solution) |
| `must book at least X days` | Date trop proche | Choisissez une date plus lointaine |
| `slot is already booked` | Créneau réservé | Changez d'heure, de jour ou de terrain |
| `site is closed on` | Site fermé ce jour | Choisissez un autre jour |
| `outside site opening hours` | Heure invalide | Choisissez une heure valide (8h-22h ou 7h-23h) |

---

## 🎯 Derniers conseils

✅ **Utilisez des valeurs simples** :
- Site : **Padel Club Lyon**
- Terrain : **Court A** (le premier)
- Date : **Dans 7 jours** (sûr pour tous les types)
- Heure : **09:00** (le matin, toujours valide)
- Type : **PUBLIC** (plus simple, pas besoin d'inviter)

❌ **Évitez** :
- Dates trop proches
- Heures en dehors des horaires d'ouverture
- Matchs PRIVÉ pour un premier test

---

## 🚀 Résumé rapide

```
1. Serveurs OK ? ✅
2. Connecté ? ✅
3. Solde = 0 EUR ? ✅
4. Pénalité = Non ? ✅
5. Date correcte ? ✅
6. Heure correcte ? ✅
7. Cliquez "Créer" 🎾
8. Si erreur → Consultez le tableau ⬆️
```

---

## 💬 Vous avez toujours un problème ?

1. **Ouvrez F12 → Console**
2. **Cherchez le message exact** après `❌ Erreur :`
3. **Consultez le tableau** ci-dessus
4. **Corrigez** et **réessayez**


