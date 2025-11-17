-- Voir tous les produits
SELECT * FROM produit;

-- Voir toutes les variantes avec leurs infos
SELECT v.id, p.nom AS produit, t.nom AS taille, c.nom AS couleur, v.stock
FROM variante v
         JOIN produit p ON v.produit_id = p.id
         JOIN taille t ON v.taille_id = t.id
         JOIN couleur c ON v.couleur_id = c.id;

-- Voir tous les avis
SELECT a.note, a.commentaire, u.nom AS utilisateur, p.nom AS produit
FROM avis a
         JOIN utilisateur u ON a.utilisateur_id = u.id
         JOIN produit p ON a.produit_id = p.id;

-- Compter les éléments
SELECT
    (SELECT COUNT(*) FROM produit) AS nb_produits,
    (SELECT COUNT(*) FROM variante) AS nb_variantes,
    (SELECT COUNT(*) FROM avis) AS nb_avis,
    (SELECT COUNT(*) FROM utilisateur) AS nb_utilisateurs;