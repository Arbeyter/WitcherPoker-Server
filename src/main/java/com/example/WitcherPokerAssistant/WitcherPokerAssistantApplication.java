package com.example.WitcherPokerAssistant;

import com.example.WitcherPokerAssistant.Assistant.*;
import com.example.WitcherPokerAssistant.SQL.ListRecordHistory;
import com.example.WitcherPokerAssistant.SQL.RecordHistory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.WitcherPokerAssistant.SQL.SQL;

import java.util.List;

@SpringBootApplication
@RestController
public class WitcherPokerAssistantApplication {

	public static void main(String[] args) {
		//
		//System.out.println(SQL.getPassword());
		SpringApplication.run(WitcherPokerAssistantApplication.class, args);
	}
//	@GetMapping("/hello")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return String.format("Hello %s!", name);
//	}
	@CrossOrigin(origins = "*")
	@PostMapping("/authorization")
	public ResponseEntity<AuthorizationAnswer> start(@RequestBody Authorization authorization){
		int playerId = SQL.checkResult(authorization.getLogin(), authorization.getPassword());
		AuthorizationAnswer answer = new AuthorizationAnswer((playerId != 0), playerId);
		return ResponseEntity.ok(answer); //idPlayer
	}
//	@CrossOrigin(origins = "*")
//	@GetMapping("/test/addresult")
//	public void test(){
//		SQL.addResult(1,true,false);
//	}
	@GetMapping("/test/check_user")
	public void testcheck_user(){
		SQL.checkResult("login", "password");
	}

	@CrossOrigin(origins = "*")
	@PostMapping("game/start")
	public ResponseEntity<Integer> start(@RequestBody Start start){
			//создать запись в БД об начале игры, вернуть gameId
		Integer gameId = SQL.addGame(start.getPlayerId());
		return  ResponseEntity.ok(gameId);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/game/step")
	public ResponseEntity<BestPick> step(@RequestBody Step step){
		//принимаю выпавшие кости и их позиции, возвращаю массив из 0 и 1. 1 - значит перебросить.
		BestPick pick = new BestPick(step);
		return ResponseEntity.ok(pick);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/game/end")
	public ResponseEntity<Void> end(@RequestBody End end){
		//завершение игры
		// TODO в бд процедуру чтобы добавлять время завершения
		//
		//System.out.println(end.getIdGame());
		SQL.addResult(end.getIdGame(), end.getPredictResult(), end.getRealResult());

		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/history")
	public ResponseEntity<List<RecordHistory>> getHistory(@RequestParam(value="pagination") Integer pagination,
														  @RequestParam(value = "page") Integer page,
														  @RequestParam(value = "playerId") Integer playerId){
		ListRecordHistory listMatch = SQL.viewHistory(pagination, page, playerId,new ListRecordHistory());
		return ResponseEntity.ok(listMatch.getRecordHistories());
	}
}
