# Solution : Extraction du message d'erreur exact

## 🎯 Objectif
Trouver le **message exact du backend** qui cause l'erreur "An unexpected error occurred".

---

## 📍 Étapes

### 1️⃣ Ouvrir la console
- Appuyez sur **F12**
- Allez à l'onglet **Console**
- **Effacez** tout ce qui est écrit (Ctrl+L ou clic droit → Clear console)

### 2️⃣ Créer un match
1. Allez à **Profil** (vérifiez que vous n'avez pas de pénalité ou de solde impayé)
2. Cliquez sur **"Créer un match PUBLIC"** (plus simple pour tester)
3. Remplissez le formulaire :
   - Site : **Padel Club Lyon**
   - Terrain : **Court A** (ou n'importe quel)
   - Date : **Mettez une date future valide** (au moins 5 jours, en fonction de votre type)
   - Heure : **09:00** (dans les heures d'ouverture)
   - Type : **PUBLIC**

4. Cliquez **"Créer le match"**

### 3️⃣ Lire la console
Vous verrez des logs comme :

```
applyMinimumBookingDate: { minDate: "2026-05-08", selectedDate: "...", ... }
Creating match with payload: { terrainId: 1, organisateurId: 5, date: "...", ... }
Match creation failed: { ... }
```

**Scroll down** pour voir ces messages :

```
=== FULL ERROR OBJECT ===
{...}
========================
Found in ...: [MESSAGE EXACT]
```

### 4️⃣ Copier le message exact
Repérez la ligne qui commence par `❌ Erreur :`.

**Exemple** :
```
❌ Erreur : Member has an outstanding balance and cannot create a match
```

Copiez ce message exactement.

---

## 📋 Tableau de décodage

| Message affiché | Cause | Solution |
|-----------------|-------|----------|
| `Member has an outstanding balance` | Solde impayé | Allez **Profil** → **Mes paiements** → payez |
| `Member has an active penalty` | Pénalité active | Attendez que la pénalité disparaisse |
| `must book at least` | Date trop proche | Choisissez une date plus lointaine |
| `slot is already booked on terrain` | Créneau occupé | Changez d'heure ou de jour |
| `The site is closed on` | Site fermé | Choisissez une autre date |
| `Requested slot is outside site opening hours` | Heure invalide | Choisissez une heure entre 8h-22h (Lyon) ou 7h-23h (Paris) |
| `Terrain not found` | Mauvais terrain | Sélectionnez un terrain valide |
| `Member not found` | Vous n'êtes pas connecté | Reconnectez-vous avec votre matricule |
| `Match not found` | Le match a été supprimé | Créez un nouveau match |

---

## ✅ Si c'est résolu

Si vous voyez un message du tableau ci-dessus :

1. **Lisez la solution** dans la colonne "Solution"
2. **Corrigez** le problème (solde, date, heure, etc.)
3. **Réessayez** la création de match

---

## 🆘 Si ce n'est pas dans le tableau

Si le message n'est **pas** dans le tableau, envoyez-moi :

1. **Le message exact** (copié de la console)
2. **Une capture d'écran** du formulaire rempli
3. **Votre type de membre** (GLOBAL/SITE/LIBRE)

---

## 🔧 Autre étape de débogage (Onglet Réseau)

Si le message n'apparaît toujours pas :

1. Ouvrez **F12** → **Réseau** (Network)
2. Créez un match
3. Cherchez la requête `matches` avec `POST`
4. Cliquez dessus
5. Allez à **Response** (ou **Réponse**)
6. Copiez tout le contenu

---

## 💻 Instructions pour exécuter les serveurs

Si vous ne l'avez pas fait :

### Terminal 1 - Backend
```powershell
cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)"
.\mvnw spring-boot:run
```

Attendez jusqu'à voir : `APPLICATION SUCCESSFUL`

### Terminal 2 - Frontend
```powershell
cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)\frontend"
npm start
```

Attendez jusqu'à voir : `Application running...`

Puis ouvrez : `http://localhost:4200`

---

## 📞 Résumé

1. **F12 → Console**
2. **Créez un match**
3. **Lisez le message exact** affiché
4. **Consultez le tableau** pour la solution
5. **Corrigez** et **réessayez**


