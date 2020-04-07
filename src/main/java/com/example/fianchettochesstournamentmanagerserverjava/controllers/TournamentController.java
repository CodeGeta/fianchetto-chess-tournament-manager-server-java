package com.example.fianchettochesstournamentmanagerserverjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fianchettochesstournamentmanagerserverjava.models.Tournament;
import com.example.fianchettochesstournamentmanagerserverjava.models.User;
import com.example.fianchettochesstournamentmanagerserverjava.services.TournamentService;

@RestController
@CrossOrigin(origins = "*")
public class TournamentController {
	
	@Autowired
	TournamentService tournamentService;
	
	@GetMapping("/api/tournament/{tournamentId}")
	public Tournament findTournamentById(@PathVariable ("tournamentId") Integer tournamentId) {
		return tournamentService.findTournamentById(tournamentId);
	}
	
	@GetMapping("/api/tournament/{tournamentId}/users")
	public List<User> findPlayersForTournament(@PathVariable ("tournamentId") Integer tournamentId) {
		return tournamentService.findPlayersForTournament(tournamentId);
	}
	
	@PostMapping("/api/tournaments")
	public Tournament createTournament(@RequestBody Tournament t) {
		return tournamentService.createTournament(t);
	}
	
	@DeleteMapping("/api/tournament/{tournamentId}")
	public void deleteTournament(@PathVariable ("tournamentId") Integer tournamentId) {
		tournamentService.deleteTournament(tournamentId);
	}
	
	@GetMapping("/api/tournaments")
	public List<Tournament> findAllTournaments() {
		return tournamentService.findAllTournaments();
	}
}