package com.foodbox.service;

import java.util.List;

import com.foodbox.exception.PuyNotFoundException;
import com.foodbox.pojo.Puy;

public interface PuyService {
	public Puy addPuy(Puy puy,Integer buyId) throws PuyNotFoundException;

	public Puy findPuy(int puyId);

	List<Puy> viewPuyList() throws PuyNotFoundException;

}
