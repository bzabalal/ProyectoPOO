package com.example.zabalaIntegrador.config;

import org.hibernate.envers.RevisionListener;
import org.springframework.data.history.Revision;

public class CustomRevisionListener implements RevisionListener {
  public void newRevision(Object revisionEntity) {final Revision revision = (Revision) revisionEntity;}
}
