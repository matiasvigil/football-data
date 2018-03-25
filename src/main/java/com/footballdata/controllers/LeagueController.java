package com.footballdata.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.footballdata.responses.AlreadyExists;
import com.footballdata.responses.NotFound;
import com.footballdata.responses.ResultCount;
import com.footballdata.responses.ServerError;
import com.footballdata.responses.Success;
import com.footballdata.services.LeagueService;

@RestController
public class LeagueController {

    private static final Logger LOGGER = Logger.getLogger(LeagueController.class.getName());

    @Autowired
    LeagueService leagueService;

    @RequestMapping("/import-league/{leagueCode}")
    @ResponseBody
    ResponseEntity importLeague(@PathVariable String leagueCode) {
        try {
            if (leagueService.importLeagueInfo(leagueCode)) {
                return new Success();
            } else {
                return new AlreadyExists();
            }
        } catch (IllegalArgumentException e) {
            return new NotFound();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return new ServerError();
        }
    }

    @RequestMapping("/total-players/{leagueCode}")
    @ResponseBody
    ResponseEntity getTotalPlayers(@PathVariable String leagueCode) {
        try {
            return new ResponseEntity(new ResultCount(leagueService.getTotalPlayers(leagueCode)), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new NotFound();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return new ServerError();
        }
    }

}