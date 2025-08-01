import sqlite3

conn = sqlite3.connect("animaux.db")  # Assure-toi que le nom est exactement le même que dans app.py
cursor = conn.cursor()

cursor.execute('''
    CREATE TABLE IF NOT EXISTS animaux (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        nom TEXT NOT NULL,
        espece TEXT NOT NULL,
        race TEXT NOT NULL,
        description TEXT,
        image TEXT
    )
''')

# Quelques entrées de test (facultatif mais utile)
cursor.executemany('''
    INSERT INTO animaux (nom, espece, race, description, image)
    VALUES (?, ?, ?, ?, ?)
''', [
    ("Mimi", "chat", "persan", "Chat doux et calme", "chat1.jpg"),
    ("Rex", "chien", "labrador", "Chien joueur", "chien1.jpg"),
    ("Coco", "oiseau", "perroquet", "Perroquet bavard", "oiseau1.jpg")
])

conn.commit()
conn.close()
print("✅ Base de données initialisée avec table 'animaux'.")
