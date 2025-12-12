from flask import Flask, render_template

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')  # Flask looks in 'templates' folder by default
@app.route('/banana')
def banana():
    return render_template('banana_bread.html')  # Flask looks in 'templates' folder by default

if __name__ == '__main__':
    app.run(debug=True)

