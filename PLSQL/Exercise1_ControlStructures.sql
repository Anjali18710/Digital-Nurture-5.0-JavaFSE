-- Scenario 1: Apply 1% discount to loan interest for customers above 60
BEGIN
    FOR rec IN (SELECT c.CustomerID, l.LoanID, l.InterestRate
                FROM Customers c
                JOIN Loans l ON c.CustomerID = l.CustomerID
                WHERE MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60)
    LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate - 1
        WHERE LoanID = rec.LoanID;
        
        DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || rec.CustomerID);
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2: Set IsVIP = TRUE for customers with balance over 10000
BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers)
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('CustomerID ' || rec.CustomerID || ' marked as VIP');
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3: Print reminders for loans due within next 30 days
BEGIN
    FOR rec IN (SELECT c.Name, l.LoanID, l.EndDate
                FROM Customers c
                JOIN Loans l ON c.CustomerID = l.CustomerID
                WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: ' || rec.Name || 
                             ' - Loan ID ' || rec.LoanID || 
                             ' due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/