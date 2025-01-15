import random

def juego_ruleta_rusa():
    print("¡Bienvenido a la ruleta rusa digital!")
    print("Adivina un número del 1 al 10. Si aciertas, ocurre algo dramático (pero inofensivo).")
    
    # Generar un número aleatorio del 1 al 10
    numero_secreto = random.randint(1, 10)
    
    # Solicitar al usuario que adivine
    try:
        eleccion = int(input("Introduce un número del 1 al 10: "))
        if eleccion < 1 or eleccion > 10:
            print("El número debe estar entre 1 y 10. ¡Juego terminado!")
            return
        
        # Comparar el número del usuario con el secreto
        if eleccion == numero_secreto:
            print("¡Bang! Has acertado... pero no pasa nada en la realidad. 😅")
        else:
            print("Te has salvado. El número era:", numero_secreto)
    except ValueError:
        print("Por favor, introduce un número válido.")

# Ejecutar el juego
juego_ruleta_rusa()
