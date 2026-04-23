# Guide de débogage - Création de match

## Erreur : "An unexpected error occurred"

Si vous rencontrez cette erreur lors de la création d'un match, suivez ce guide.

---

## 1️⃣ Vérifier la console du navigateur

Appuyez sur **F12** (ou Ctrl+Shift+I) pour ouvrir les outils de développement.

Allez dans l'onglet **Console** et créez un match. Vous verrez des logs comme :

```
applyMinimumBookingDate: { 
  minDate: "2026-05-08", 
  selectedDate: "2026-05-08", 
  memberType: "GLOBAL" 
}
Creating match with payload: {
  terrainId: 1,
  organisateurId: 5,
  date: "2026-05-08",
  heureDebut: "09:00",
  typeMatch: "PUBLIC"
}
```

### ✅ Si vous voyez ces logs :
Vérifiez qu'aucune erreur n'apparaît après. Si une erreur apparaît, allez à l'étape 2.

### ❌ Si `date` ou `heureDebut` sont vides :
C'est le problème ! Le formulaire n'a pas reçu les données correctement.
- **Solution** : Rechargez la page et essayez à nouveau.

---

## 2️⃣ Vérifier la réponse de l'API

Dans la console, allez dans l'onglet **Réseau** (Network).

Créez un match et trouvez la requête `POST /api/matches`.

### Vérifier la requête
- **URL** : `http://localhost:8080/api/matches`
- **Méthode** : `POST`
- **Headers** : Vérifiez que `Content-Type: application/json` est présent

### Vérifier le body
Cliquez sur l'onglet **Payload** ou **Request** et vérifiez que les données sont correctes :

```json
{
  "terrainId": 1,
  "organisateurId": 5,
  "date": "2026-05-08",
  "heureDebut": "09:00",
  "typeMatch": "PUBLIC"
}
```

### Vérifier la réponse
Cliquez sur l'onglet **Response**.

- **Status 201** ✅ : Match créé avec succès
- **Status 400** ⚠️ : Erreur de validation (voir la réponse pour les détails)
- **Status 500** ❌ : Erreur serveur

---

## 3️⃣ Codes d'erreur courants

### 400 - "Member has an outstanding balance"
**Cause** : Vous avez un solde impayé.
**Solution** : Allez dans **Mes paiements** et réglez vos dettes.

### 400 - "Member has an active penalty"
**Cause** : Vous avez une pénalité active (un match privé ne s'était pas rempli).
**Solution** : Attendez que la pénalité expire.

### 400 - "must book at least 21 days in advance"
**Cause** : Vous n'avez pas respecté le délai d'avance requis.
- **GLOBAL** : 21 jours (3 semaines)
- **SITE** : 14 jours (2 semaines)  
- **LIBRE** : 5 jours

**Solution** : Choisissez une date plus lointaine (à partir du 08/05/2026 si vous êtes LIBRE).

### 400 - "This slot is already booked"
**Cause** : Ce créneau horaire est déjà réservé sur ce terrain.
**Solution** : Choisissez une autre heure ou un autre jour.

### 400 - "The site is closed on"
**Cause** : Le site est fermé à cette date.
**Solution** : Choisissez un autre jour.

### 400 - "Requested slot is outside site opening hours"
**Cause** : L'heure demandée dépasse les horaires d'ouverture du site.
- Lyon : 8h - 22h
- Paris : 7h - 23h

**Solution** : Choisissez une heure dans les horaires d'ouverture.

### 500 - Erreur serveur
**Cause** : Erreur côté backend.
**Solution** : Vérifiez les logs du backend (voir étape 4).

---

## 4️⃣ Vérifier les logs du backend

Si vous lancez le backend en développement, regardez la console Spring Boot.

Cherchez des messages comme :

```
[INFO] Match created by member 5 on terrain 1 at 2026-05-08
```

Ou une exception comme :

```
java.lang.Exception: ...
  at com.padelPlay.service.impl.MatchServiceImpl.create(MatchServiceImpl.java:X)
```

---

## 5️⃣ Checklist

Avant de créer un match, assurez-vous que :

- ✅ Vous êtes connecté avec votre matricule (ex: `G1001`, `S10001`, `L10001`)
- ✅ Pas de pénalité active (affichée dans votre profil)
- ✅ Pas de solde impayé (affichée dans votre profil)
- ✅ Vous respectez le délai d'avance selon votre type de membre
- ✅ Vous avez choisi un **site** et un **terrain**
- ✅ La date et l'heure sont dans les horaires du site
- ✅ Le créneau n'est pas déjà réservé sur ce terrain

---

## 🆘 Toujours un problème ?

Vérifiez que le backend est bien en cours d'exécution :

```powershell
cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)"
.\mvnw spring-boot:run
```

Vous devriez voir `APPLICATION SUCCESSFUL` après environ 10 secondes.

Si ce n'est pas le cas, il y a peut-être une erreur de démarrage du backend. Cherchez des messages d'erreur dans la console.


