//************************************************************************
//  RoShamBoFX.java       Author: Em Powers
//
//  Demonstrates a game of Ro-Sham-Bo (rock, paper, scissors) 
//  This game is user-playable and implements JavaFX.
//************************************************************************

import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class RoShamBoFX extends Application {

	private ImageView computerMoveImageView, userMoveImageView;
	private Image rockImage, paperImage, scissorsImage;
	private Text matchOutcomeText, cWinsText, uWinsText, tieText;
	private Text betText;
	private Button rockButton, paperButton, scissorsButton;
	private HBox labelBox;
	private HBox imageBox;
	private HBox buttonBox;
	private HBox statsBox;
	private HBox bettingField;
	private RoShamBo game;

	public void start(Stage primaryStage) {
		
		/* the image and labels for if the bets */
		betText = new Text("Your balance is: " + game.getAmount());
		betText.setFont(Font.font("Helvetica", 14));
		betText.setFill(Color.BLUE);
		bettingField = new HBox(betText);
		bettingField.setVisible(false);
		bettingField.setAlignment(Pos.CENTER);
		int betAmount = this.getBetAmount(); 
		game = new RoShamBo(betAmount);

		/* the image and labels for the computer and user move */
		rockImage = new Image("https://i.imgur.com/mhocdls.jpg");
		paperImage = new Image("https://i.imgur.com/o8vIF2m.jpg");
		scissorsImage = new Image("https://i.imgur.com/OFlpgBH.jpg");

		computerMoveImageView = new ImageView(rockImage);
		computerMoveImageView.setVisible(false); // used to make the initial screen layout appear the same as when the game starts
		userMoveImageView = new ImageView(rockImage);
		userMoveImageView.setVisible(false); 
		HBox imageBox = new HBox(computerMoveImageView, userMoveImageView);
		imageBox.setAlignment(Pos.CENTER);
		imageBox.setSpacing(20);

		Text computerLabel = new Text("Computer's Move");
		computerLabel.setFont(Font.font("Helvetica", 14));
		Text yourLabel = new Text("Your Move");
		yourLabel.setFont(Font.font("Helvetica", 14));
		labelBox = new HBox(computerLabel, yourLabel);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.setSpacing(30);
		labelBox.setVisible(false);

		/* the results of each match */
		matchOutcomeText = new Text();
		matchOutcomeText.setFill(Color.GREEN);
		matchOutcomeText.setFont(Font.font("Helvetica", 20));

		/* the buttons for the user's play */
		rockButton = new Button("Play Rock");
		rockButton.setOnAction(this::handleUserPlay);
		paperButton = new Button("Play Paper");
		paperButton.setOnAction(this::handleUserPlay);
		scissorsButton = new Button("Play Scissors");
		scissorsButton.setOnAction(this::handleUserPlay);
		HBox buttonBox = new HBox(rockButton, paperButton, scissorsButton);
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.CENTER);
		 
		/* the game statistics */
		cWinsText = new Text("Computer Wins: " + game.getCWins());
		cWinsText.setFont(Font.font("Helvetica", 16));
		cWinsText.setFill(Color.BLUE);
		uWinsText = new Text("User Wins: " + game.getUWins());
		uWinsText.setFont(Font.font("Helvetica", 16));
		uWinsText.setFill(Color.BLUE);
		tieText = new Text("Ties: " + game.getTies());
		tieText.setFont(Font.font("Helvetica", 16));
		tieText.setFill(Color.BLUE);
		HBox statsBox = new HBox(cWinsText, uWinsText, tieText);
		statsBox.setSpacing(10);
		statsBox.setAlignment(Pos.CENTER);
		
		VBox pane = new VBox(imageBox, labelBox, matchOutcomeText, buttonBox, statsBox, bettingField);
		pane.setAlignment(Pos.CENTER);
		pane.setSpacing(20);
		pane.setStyle("-fx-background-color: white");

		Scene scene = new Scene(pane, 400, 400, Color.TRANSPARENT);
		primaryStage.setTitle("Rock, Paper, Scissors, Go!");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	 //--------------------------------------------------------------------
   //  Displays an alert box asking the user if they want to 
   //  place a bet, and returns a value if they do. 
   //--------------------------------------------------------------------
	
	private int getBetAmount() {
        int betAmount = 0;
        
        Alert betDialog = new Alert(Alert.AlertType.CONFIRMATION, "Do you want to bet?", new ButtonType[]{ButtonType.YES, ButtonType.NO});
        betDialog.setHeaderText(null);
        Optional selection = betDialog.showAndWait();
        if (selection.isPresent() && ((ButtonType)selection.get()).equals((Object)ButtonType.YES)) {
            TextInputDialog inputDialog = new TextInputDialog();
            inputDialog.setContentText("Enter the bet amount:");
            inputDialog.setTitle("Bet amount");
            inputDialog.setHeaderText(null);
            Optional userInput = inputDialog.showAndWait();
            
            if (userInput.isPresent()) {
                try {
                    betAmount = Integer.parseInt((String)userInput.get());
                    bettingField.setVisible(true);
                }
                // The exception handler for if a non-numeric value is entered
                catch (NumberFormatException num) {
                    Alert error = new Alert(Alert.AlertType.ERROR);
                    error.setContentText("That is not valid. A number needs to be entered.");
                    error.setHeaderText(null);
                    error.showAndWait();
                }
            } else {
            	 // The exception handler for if the box is closed 
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("That is not valid. A number needs to be entered.");
                error.setHeaderText(null);
                error.showAndWait();
            }
        }
        return betAmount;
    }
	
	 //--------------------------------------------------------------------
   //  Acts as the user handler.
   //--------------------------------------------------------------------
	
    private void handleUserPlay(ActionEvent event) {
    	
    	userMoveImageView.setVisible(true);
		computerMoveImageView.setVisible(true);
		labelBox.setVisible(true);
        
        Object source = event.getSource();
        int userPlay = 0;
        
        if (source == rockButton) {
            userPlay = RoShamBo.ROCK;
            userMoveImageView.setImage(rockImage);
        } else if (source == paperButton) {
            userPlay = RoShamBo.PAPER;
            userMoveImageView.setImage(paperImage);
        } else if (source == scissorsButton) {
            userPlay = RoShamBo.SCISSORS;
            userMoveImageView.setImage(scissorsImage);
        }
        
        int computerPlay = game.generateComputerPlay();
        setDisplay(computerPlay);
        int winner = game.findWinner(userPlay, computerPlay);
        updatePane(winner, userPlay, computerPlay);
        betText.setText("Your balance is: " + game.getAmount());
        
    }
    
	 //--------------------------------------------------------------------
   //  Resets the display with the move chosen by the computer.
   //--------------------------------------------------------------------

	private void setDisplay(int computerMove)
		{		
			if (computerMove == RoShamBo.ROCK)
				{
					
					computerMoveImageView.setImage(rockImage);	
			}else if (computerMove == RoShamBo.PAPER)
				{
					computerMoveImageView.setImage(paperImage);
			}else if (computerMove == RoShamBo.SCISSORS)
			{
					computerMoveImageView.setImage(scissorsImage);
				}
		}
	
	 //--------------------------------------------------------------------
   //  Updates the scene with result values. 
   //--------------------------------------------------------------------
	
	private void updatePane(int result, int aiMove, int pMove)
		{
			if (result == RoShamBo.TIE)
				{
					matchOutcomeText.setText(" You tied!");
					
				}else if (result == RoShamBo.COMPUTER)
					{
						String resultText;
						resultText = aiMove == RoShamBo.ROCK ? "Paper covers rock!" : (aiMove == RoShamBo.PAPER ? "Scissors cut paper!" : "Rock breaks Scissors!");
						matchOutcomeText.setText(String.valueOf(resultText) + " You lose!");
				}else if (result == RoShamBo.USER)
					{
						String resultText;
						resultText = pMove == RoShamBo.ROCK ? "Paper covers rock!" : (pMove == RoShamBo.PAPER ? "Scissors cut paper!" : "Rock breaks Scissors!");
						matchOutcomeText.setText(String.valueOf(resultText) + " You win!");
					}
				tieText.setText("Ties: " + game.getTies());
				uWinsText.setText("Computer wins: " + game.getCWins());
				cWinsText.setText("User wins: " + game.getUWins());
		}
	
	 //--------------------------------------------------------------------
   //  Launches the game. 
   //--------------------------------------------------------------------
	
	public static void main(String[] args) {
		launch(args);
	}

}
