package com.stoktakip.stoktakip.controller;


import java.util.List;

import com.stoktakip.stoktakip.model.Kargofirmasi;
import com.stoktakip.stoktakip.model.Siparis;
import com.stoktakip.stoktakip.model.Urun;
import com.stoktakip.stoktakip.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.stoktakip.stoktakip.model.Musteri;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/musteri")
public class MusteriController {

    @Autowired
    MusteriService musteriService;
    UrunService urunService;
    KargofirmasiService kargofirmasiService;
    SatistemsilcisiService satistemsilcisiService;
    IllerService illerService;
    KategoriService kategoriService;

    @RequestMapping(value = "/musteri", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("musteri") Musteri musteri, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();

        List<Musteri> personeller = musteriService.getAllMusteri();
        for (Musteri musteri1 : personeller) {
            if (musteri1.getKullaniciadi().equals(musteri.getKullaniciadi()) && musteri1.getSifre().equals(musteri.getSifre())) {
                model.addObject("musteri", musteri1);
                Cookie cookie = new Cookie("musteri", musteri.getKullaniciadi());
                cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
                response.addCookie(cookie);

                model.setViewName("musteri_anasayfa");

                return model;
            }
        }


        model.setViewName("redirect:/musteri/musteri_login");
        return model;
    }

    @RequestMapping(value = "/musteri_login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView model = new ModelAndView("musteri_login");
        return model;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {

        ModelAndView model = new ModelAndView("musteri_list");
        List<Musteri> musteriList = musteriService.getAllMusteri();
        model.addObject("musteriList", musteriList);

        return model;
    }


    @RequestMapping(value = "/addMusteri/", method = RequestMethod.GET)
    public ModelAndView addMusteri() {

        ModelAndView model = new ModelAndView();
        Musteri musteri = new Musteri();
        model.addObject("musteriForm", musteri);
        model.setViewName("musteri_form");

        return model;
    }
    @GetMapping({"/satistemsilcisi/satistemsilcisi_login"})
    public String home5() {return"satistemsilcisi_anasayfa";}


    @RequestMapping(value = "/editMusteri/{id}", method = RequestMethod.GET)
    public ModelAndView editMusteri(@PathVariable int id) {
        ModelAndView model = new ModelAndView();

        Musteri musteri = musteriService.getMusteriById(id);
        model.addObject("musteriForm", musteri);
        model.setViewName("musteri_form");

        return model;
    }


    @RequestMapping(value = "/addMusteri", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("musteriForm") Musteri musteri) {

        musteriService.addMusteri(musteri);
        return new ModelAndView("redirect:/musteri/list");

    }

    @RequestMapping(value = "/deleteMusteri/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {

        musteriService.deleteMusteri(id);
        return new ModelAndView("redirect:/musteri/list");

    }




    }

