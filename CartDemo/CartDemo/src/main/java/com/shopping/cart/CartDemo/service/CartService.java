package com.shopping.cart.CartDemo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.cart.CartDemo.Response.CartResponseInfo;
import com.shopping.cart.CartDemo.Response.Data;
import com.shopping.cart.CartDemo.model.CartRequestInfo;

@Service
public class CartService {
	
	public static Map<String,Object> map= new HashMap<String,Object>();
	public static int usedOrdNo=1;
	
	public ResponseEntity<CartResponseInfo> cartCreation(CartRequestInfo cartRequestInfo) {
		map.put("Ord-"+ usedOrdNo, cartRequestInfo);
		CartResponseInfo cartResponseInfo=new CartResponseInfo();
		cartResponseInfo.setStatus("200");
		cartResponseInfo.setMessage("data-saved -orderno: " + "Ord-" + usedOrdNo);
		++usedOrdNo;
		return new ResponseEntity<>(cartResponseInfo,HttpStatus.OK);
		
	}
	
	public ResponseEntity<CartResponseInfo> retreive(String ordNo) {
		CartRequestInfo cartRequestInfo=(CartRequestInfo)map.get(ordNo);
		CartResponseInfo cartResponseInfo=new CartResponseInfo();
		cartResponseInfo.setStatus("200");
		Data data=new Data();
		data.setSku(cartRequestInfo.getData().getSku());
		data.setName(cartRequestInfo.getData().getName());
		data.setQuantity(cartRequestInfo.getData().getQuantity());
		data.setPricePerUnit(cartRequestInfo.getData().getPricePerUnit());
		cartResponseInfo.setData(data);
		return new ResponseEntity<>(cartResponseInfo,HttpStatus.OK);
	}
	
	public ResponseEntity<CartResponseInfo> modification(String ordNo,CartRequestInfo cartRequestInfo) {
		map.put(ordNo,cartRequestInfo);
		CartResponseInfo cartResponseInfo=new CartResponseInfo();
		cartResponseInfo.setStatus("200");
		cartResponseInfo.setMessage("data-modified -orderno: " + "Ord-" + usedOrdNo);
		return new ResponseEntity<>(cartResponseInfo,HttpStatus.OK);
	}
	
	
	
	
	
	

}
