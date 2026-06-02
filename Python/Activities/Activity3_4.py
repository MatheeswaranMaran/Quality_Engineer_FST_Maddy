while True:
    player1 = input("Player 1: Enter Rock, Paper, Scissors? ").lower()
    player2 = input("Player 2: Enter Rock, Paper, Scissors? ").lower()

    valid_choices = ["rock", "paper", "scissors"]

    if player1 not in valid_choices or player2 not in valid_choices:
        print("Invalid option! Please choose Rock, Paper, or Scissors.")
        continue

    if player1 == player2:
        print("Draw")
    elif (
        (player1 == "rock" and player2 == "scissors") or
        (player1 == "paper" and player2 == "rock") or
        (player1 == "scissors" and player2 == "paper")
    ):
        print("Player 1 wins")
    else:
        print("Player 2 wins")

    choice = input("Play again? (y/n): ").lower()

    if choice != "y":
        print("Thanks for playing!")
        raise SystemExit