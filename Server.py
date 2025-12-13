from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')  # Flask looks in 'templates' folder by default
@app.route('/home')
def new_home():
    return render_template('index.html')  # Flask looks in 'templates' folder by default
@app.route('/banana')
def banana():
    return render_template('banana_bread.html')  # Flask looks in 'templates' folder by default
@app.route('/recipies')
def recipies():
    return render_template('recipies.html')  # Flask looks in 'templates' folder by default

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=1234, debug=True)

