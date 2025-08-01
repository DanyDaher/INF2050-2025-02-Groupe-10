# Copyright 2024 <Votre nom et code permanent>
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
import os
import sqlite3
from flask import Flask, request, render_template, g , redirect, url_for

app = Flask(__name__)
DATABASE = "animaux.db" 
# Fonction pour obtenir la connexion à la base SQLite
def get_db_connection():
    BASE_DIR = os.path.dirname(os.path.abspath(__file__))
    DB_PATH = os.path.join(BASE_DIR, 'db', 'animaux.db')  # Assure-toi que la base est là
    conn = sqlite3.connect(DB_PATH)
    conn.row_factory = sqlite3.Row
    return conn

def get_db():
    if 'db' not in g:
        g.db = sqlite3.connect(DATABASE)
        g.db.row_factory = sqlite3.Row  # Pour pouvoir accéder aux colonnes par nom
    return g.db

# Page d'accueil : 5 animaux aléatoires
@app.route('/')
def accueil():
    conn = get_db_connection()
    animaux = conn.execute("SELECT * FROM animaux ORDER BY RANDOM() LIMIT 5").fetchall()
    conn.close()
    return render_template('accueil.html', animaux=animaux)

# Page d'un animal précis
@app.route('/animal/<int:animal_id>')
def animal(animal_id):
    conn = get_db_connection()
    animal = conn.execute("SELECT * FROM animaux WHERE id = ?", (animal_id,)).fetchone()
    conn.close()
    if animal is None:
        return "Animal non trouvé", 404
    return render_template('animal.html', animal=animal)

# Page de recherche (formulaire)
@app.route('/recherche')
def recherche():
    return render_template('recherche.html')

# Page résultats recherche
@app.route("/resultats")
def resultats():
    q = request.args.get("q", "").strip()
    db = get_db()
    animaux = []

    if q:
        animaux = db.execute(
            "SELECT * FROM animaux WHERE nom LIKE ? OR espece LIKE ? OR race LIKE ?",
            (f"%{q}%", f"%{q}%", f"%{q}%")
        ).fetchall()

    return render_template("recherche.html", animaux=animaux, requete=q)

# Route pour ajouter un animal (exemple simple)
@app.route('/ajouter', methods=['GET', 'POST'])
def ajouter():
    if request.method == 'POST':
        nom = request.form['nom']
        espece = request.form['espece']
        race = request.form['race']
        age = int(request.form['age'])
        description = request.form['description']
        courriel = request.form['courriel']
        adresse = request.form['adresse']
        ville = request.form['ville']
        cp = request.form['cp']

        conn = get_db_connection()
        conn.execute(
            "INSERT INTO animaux (nom, espece, race, age, description, courriel, adresse, ville, cp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
            (nom, espece, race, age, description, courriel, adresse, ville, cp)
        )
        conn.commit()
        conn.close()

        return redirect(url_for('accueil'))
    return render_template('form.html')

if __name__ == '__main__':
    app.run(debug=True)
