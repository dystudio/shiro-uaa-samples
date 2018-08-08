package com.github.xfslove.service;

import com.github.xfslove.autoconfigure.shiro.model.AuthCode;
import com.github.xfslove.autoconfigure.shiro.service.AuthCodeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanwen on 2018/8/8.
 */
@Service
public class MemAuthCodeService implements AuthCodeService {

  private Map<String, AuthCode> db = new ConcurrentHashMap<>(64);

  @Override
  public void save(AuthCode authCode) {
    db.put(authCode.getCode(), authCode);
  }

  @Override
  public AuthCode getByCode(String code) {
    return db.get(code);
  }

  @Override
  public boolean remove(String code) {
    return db.remove(code) != null;
  }
}
