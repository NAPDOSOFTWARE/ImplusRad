package gnu.kawa.lispexpr;

import gnu.mapping.Namespace;

class NamespaceUse
{
  Namespace imported;
  Namespace importing;
  NamespaceUse nextImported;
  NamespaceUse nextImporting;
}


/* Location:           C:\Users\Bonjour\Desktop\classes_dex2jar.jar
 * Qualified Name:     gnu.kawa.lispexpr.NamespaceUse
 * JD-Core Version:    0.7.0.1
 */