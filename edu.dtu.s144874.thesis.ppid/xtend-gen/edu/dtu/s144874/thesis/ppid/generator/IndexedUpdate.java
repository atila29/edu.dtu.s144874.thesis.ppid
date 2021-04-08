package edu.dtu.s144874.thesis.ppid.generator;

import edu.dtu.s144874.thesis.ppid.ppid.SourceUpdate;

@SuppressWarnings("all")
public class IndexedUpdate {
  private SourceUpdate update;
  
  private Integer index;
  
  public IndexedUpdate(final int index, final SourceUpdate update) {
    this.index = Integer.valueOf(index);
    this.update = update;
  }
  
  public Integer getGetIndex() {
    return this.index;
  }
  
  public SourceUpdate getUpdate() {
    return this.update;
  }
}
