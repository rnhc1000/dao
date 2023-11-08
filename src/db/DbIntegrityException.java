package db;

/**
 * Motivation: Avoid referential erros when
 * deleting rows at the DB
 */
public class DbIntegrityException extends RuntimeException{

  private static final long serialVersionUUID = 1L;
  public DbIntegrityException(String msg) {
    super(msg);
  }
}
