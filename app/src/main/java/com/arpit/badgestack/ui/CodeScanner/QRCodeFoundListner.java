package com.arpit.badgestack.ui.CodeScanner;

public interface QRCodeFoundListner {
    void onQRCodeFound(String qrCode);
    void qrCodeNotFound();
}
