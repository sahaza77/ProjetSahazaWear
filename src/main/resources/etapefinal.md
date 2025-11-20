🛡️ Attaque CSRF - Explication et Protection
📚 Qu'est-ce qu'une attaque CSRF ?
CSRF (Cross-Site Request Forgery) est une attaque qui force un utilisateur authentifié à exécuter des actions non désirées sur une application web où il est connecté.
Exemple d'attaque :

Vous êtes connecté sur SahazaWear
Vous visitez un site malveillant (ex: site-pirate.com)
Ce site contient un formulaire caché qui envoie une requête POST vers sahazawear.com/admin/supprimerProduit
Votre navigateur envoie automatiquement vos cookies de session
✅ L'action est exécutée sans votre consentement !


aide pour prompt dm :
🔍 Si tu veux, je peux aussi te générer :

le fichier profile.html de base

le fichier dashboard.html admin

un header qui montre “Bonjour {nom}”

une navbar différente selon le rôle