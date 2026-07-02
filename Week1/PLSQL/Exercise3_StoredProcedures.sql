-- Scenario 1: Process monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Customers
    SET Balance = Balance * 1.01;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all accounts.');
END;
/

-- Scenario 2: Update employee bonus by department
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department VARCHAR2,
    p_bonus_percent NUMBER
) AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percent || 
                         '% applied to department: ' || p_department);
END;
/

-- Scenario 3: Transfer funds between accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_id NUMBER,
    p_to_id NUMBER,
    p_amount NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Customers
    WHERE CustomerID = p_from_id;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in account ' || p_from_id);
    ELSE
        UPDATE Customers SET Balance = Balance - p_amount WHERE CustomerID = p_from_id;
        UPDATE Customers SET Balance = Balance + p_amount WHERE CustomerID = p_to_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || 
                             ' from CustomerID ' || p_from_id || 
                             ' to CustomerID ' || p_to_id);
    END IF;
END;
/

-- Test all three procedures
BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('Engineering', 10);
    TransferFunds(1, 2, 500);
    TransferFunds(4, 1, 9999); -- should fail - insufficient balance
END;
/