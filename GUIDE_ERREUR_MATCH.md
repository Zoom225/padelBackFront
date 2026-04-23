# Dépannage : "An unexpected error occurred"

## 🔍 Comment trouver l'erreur exacte

### Étape 1 : Ouvrir les outils de développement
1. Appuyez sur **F12** sur votre clavier
2. Allez à l'onglet **Console**
3. Essayez de créer un match

Vous verrez des logs comme celui-ci :
```
applyMinimumBookingDate: { minDate: "2026-05-08", ... }
Creating match with payload: { terrainId: 1, organisateurId: 5, ... }
Match created successfully: { id: 123, ... }
Starting handleInvites for match: 123
```

### Étape 2 : Vérifier le type d'erreur

#### ❌ Si l'erreur apparaît à "Creating match with payload"
Cela signifie que la création du match elle-même échoue. C'est l'erreur la plus courante.

**Regardez les logs :**
```
Match creation failed: {...}
Error creating match: {...}
Full error object: {...}
Extracted message: "..."
```

### Étape 3 : Identifier le problème

Regardez le message d'erreur extrait. Voici les causes courantes :

| Message | Cause | Solution |
|---------|-------|----------|
| `outstanding balance` | Solde impayé | Allez à **Mes paiements** et payez |
| `active penalty` | Pénalité active | Attendez que la pénalité expire |
| `must book at least 21 days` | Délai d'avance non respecté | Choisissez une date plus lointaine |
| `slot is already booked` | Créneau réservé | Choisissez une autre heure |
| `site is closed` | Site fermé ce jour | Choisissez un autre jour |
| `outside site opening hours` | Heure invalide | Choisissez une heure du site |

---

## 🚨 Si le message n'est pas reconnu

Si l'erreur affichée n'est pas dans la liste ci-dessus, vous verrez :
```
❌ Erreur : [message exact du backend]
```

Prenez une **capture d'écran** de ce message et vérifiez le tableau du backend ci-dessous.

---

## 📋 Vérification avant de créer

Avant de créer un match, allez à **Profil** et vérifiez :

| Élément | Valeur attendue | Où vérifier |
|---------|-----------------|-------------|
| **Solde** | 0 EUR (pas de dette) | Profil → "Solde" |
| **Pénalité** | Non | Profil → "Pénalité active" |
| **Type de membre** | GLOBAL / SITE / LIBRE | Profil → "Type" |

---

## 📅 Dates autorisées

Selon votre type de membre, la date minimale change :

| Type | Délai min. | Date min. actuelle | Note |
|------|-----------|------------------|------|
| **GLOBAL** | 21 jours | 14/05/2026 | 3 semaines |
| **SITE** | 14 jours | 07/05/2026 | 2 semaines |
| **LIBRE** | 5 jours | 29/04/2026 | 5 jours |

Vous verrez la date minimale autorisée **dans le formulaire de création de match**.

---

## 🕐 Horaires des sites

Vérifiez que l'heure du match est entre :

- **Padel Club Lyon** : 8h - 22h
- **Padel Club Paris** : 7h - 23h

Par exemple, si vous choisissez 22h30 à Lyon, ce sera rejeté car le site ferme à 22h.

---

## 💡 Conseil supplémentaire

Après avoir vu l'erreur exacte :

1. **Attendez 5 secondes** - l'erreur reste affichée
2. **Lisez le message complet** - il contient la solution
3. **Corrigez le problème** - modifiez la date, le terrain, etc.
4. **Réessayez** - créez le match à nouveau

---

## 🔧 Si vous avez toujours un problème

1. **Vérifiez que le backend est en cours d'exécution** :
   ```powershell
   cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)"
   .\mvnw spring-boot:run
   ```

2. **Vérifiez que le frontend accède au backend** :
   - Ouvrez **F12** → **Réseau**
   - Créez un match
   - Cherchez une requête `POST /api/matches`
   - Vérifiez le **Status** (doit être 201 ou 400, pas 0 ou 502)

3. **Redémarrez les deux serveurs** :
   ```powershell
   # Terminal 1 - Backend
   cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)"
   .\mvnw clean spring-boot:run
   
   # Terminal 2 - Frontend
   cd "C:\Users\user\Documents\PadelMultiple-master (1)\PadelMultiple-master(2)\frontend"
   npm start
   ```

---

## 📞 Informations supplémentaires

Pour plus de détails, consultez : **CREATION_MATCH_GUIDE.md**


