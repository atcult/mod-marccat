/*
 * (c) LibriCore
 *
 * Created on Jan 18, 2005
 *
 * ControlNumberType.java
 */
package org.folio.marccat.dao.persistence;

/**
 * @author paulm
 * @version $Revision: 1.1 $, $Date: 2005/01/21 15:47:35 $
 * @since 1.0
 */
public class ControlNumberType extends T_SINGLE {
  public static boolean isISBN(short t) {
    return t == 9;
  }
  public static boolean isISSN(short t) {
    return t == 10;
  }
  public static boolean isISMN(short t) {
    return  t == 20 ||
      t == 21 ||
      t == 22;
  }
  public static boolean isPublisherNumber(short t) {
    return  t == 37 ||
      t == 40 ||
      t == 43 ||
      t == 46 ||
      t == 49;
  }

}
