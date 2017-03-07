# NFC
Parte del progetto di maturità: identificazione personale e mezzi mediante TAG Nfc.
L'app permette di leggere e scrivere dati nei vari settori del TAG.

I TAG supportati fanno uso delle seguenti classi:

-android.nfc.tech.MifareClassic
-android.nfc.tech.NdefFormatable
-android.nfc.tech.NfcA

# Fase attuale:
  Si controlla che l'antenna nfc sia attiva
  Si cattura l'intent sviluppato dall'avvicinamento del tag
  
# To do:
  Scrittura sul settore 1
  Lettura id
  Lettura dal settore 1
 
